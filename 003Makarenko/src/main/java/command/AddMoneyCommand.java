package command;

import entity.User;
import helper.UserHelper;
import interfaces.Command;

import javax.servlet.http.HttpServletRequest;

public class AddMoneyCommand implements Command {
    @Override
    public String execute(HttpServletRequest req) {
        User user = (User) req.getSession().getAttribute("user");
        double balance = user.getBalance();
        double add = Double.parseDouble(req.getParameter("add"));
        user.setBalance(balance + add);

        UserHelper userHelper = new UserHelper();
        userHelper.update(user.getId(), user);

        return "controller?action=main";
    }
}
