package command;

import entity.Salt;
import entity.User;
import helper.MeshPassword;
import helper.SaltHelper;
import helper.UserHelper;
import interfaces.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Random;
import java.util.Set;

public class RegisterCommand implements Command {
    @Override
    public String execute(HttpServletRequest req) {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        UserHelper userHelper = new UserHelper();
        Set<User> users = userHelper.getAll();

        User user = new User(login);
        boolean created = false;

        if (!users.contains(user))
        {
            byte[] bytes = new byte[32];
            new Random().nextBytes(bytes);
            String saltStr = new String(bytes);
            String hash = MeshPassword.mesh(password, saltStr);
            user.setAuth_str(hash);

            created = true;
            userHelper.add(user);

            SaltHelper saltHelper = new SaltHelper();
            int userId = userHelper.getByLogin(user.getLogin()).getId();
            Salt salt = new Salt(userId, new String(saltStr));
            saltHelper.add(salt);

            HttpSession session = req.getSession();
            session.setAttribute("user", user);
        }
        else
            req.setAttribute("notAdd", "User already exists");
        return created ? "controller?action=main" : "register.jsp";
    }
}
