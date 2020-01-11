package command;

import entity.Salt;
import entity.User;
import helper.MeshPassword;
import helper.SaltHelper;
import helper.UserHelper;
import interfaces.Command;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest req) {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        UserHelper userHelper = new UserHelper();
        User user = userHelper.getByLogin(login);

        boolean exists = user != null;
        boolean rightPassword = false;

        if (exists) {
            req.getSession().setAttribute("user", user);

            SaltHelper saltHelper = new SaltHelper();
            Salt salt = saltHelper.getById(user.getId());
            String hash = MeshPassword.mesh(password, salt.getValue());

            rightPassword = hash.equals(user.getAuth_str());
            if (!rightPassword)
                req.setAttribute("wrongPassword", "Wrong user's password");
        }
        else
            req.setAttribute("doesNotExist", "Can't find the user");
        return exists && rightPassword ? "controller?action=main" : "login.jsp";
    }
}
