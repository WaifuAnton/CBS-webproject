package command;

import entity.Conditioner;
import entity.ElectricityItem;
import entity.Kettle;
import entity.WashingMachine;
import helper.ConditionerHelper;
import helper.ElectricityItemHelper;
import helper.KettleHelper;
import helper.WashingMachineHelper;
import interfaces.Command;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class MainCommand implements Command {
    @Override
    public String execute(HttpServletRequest req) {
        ElectricityItemHelper electricityItemHelper = new ElectricityItemHelper();
        ConditionerHelper conditionerHelper = new ConditionerHelper();
        KettleHelper kettleHelper = new KettleHelper();
        WashingMachineHelper washingMachineHelper = new WashingMachineHelper();

        List<ElectricityItem> electricityItems = electricityItemHelper.getAll();
        List<Conditioner> conditioners = conditionerHelper.getAll();
        List<Kettle> kettles = kettleHelper.getAll();
        List<WashingMachine> washingMachines = washingMachineHelper.getAll();

        List<ElectricityItem> allItems = new ArrayList<>();
        allItems.addAll(electricityItems);
        allItems.addAll(conditioners);
        allItems.addAll(kettles);
        allItems.addAll(washingMachines);

        req.setAttribute("items", allItems);
        return "main.jsp";
    }
}
