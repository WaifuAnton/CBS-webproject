package command;

import entity.*;
import helper.ConditionerHelper;
import helper.ElectricityItemHelper;
import helper.KettleHelper;
import helper.WashingMachineHelper;
import interfaces.Command;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class MyDevicesCommand implements Command {
    @Override
    public String execute(HttpServletRequest req) {
        User user = (User) req.getSession().getAttribute("user");
        String login = user.getLogin();

        ElectricityItemHelper electricityItemHelper = new ElectricityItemHelper();
        ConditionerHelper conditionerHelper = new ConditionerHelper();
        KettleHelper kettleHelper = new KettleHelper();
        WashingMachineHelper washingMachineHelper = new WashingMachineHelper();

        List<ElectricityItem> myElectricityItems = new ArrayList<>(),
                allElectricityItems = electricityItemHelper.getAll();
        List<Conditioner> myConditioners = new ArrayList<>(),
                allConditioners = conditionerHelper.getAll();
        List<Kettle> myKettles = new ArrayList<>(),
                allKettles = kettleHelper.getAll();
        List<WashingMachine> myWashingMachines = new ArrayList<>(),
                allWashingMachines = washingMachineHelper.getAll();

        for(Kettle kettle : allKettles)
            if (kettle.getUsedBy().equals(login))
                myKettles.add(kettle);

        for(ElectricityItem item : allElectricityItems)
            if (item.getUsedBy().equals(login))
                myElectricityItems.add(item);

        for(Conditioner conditioner : allConditioners)
            if (conditioner.getUsedBy().equals(login))
                myConditioners.add(conditioner);

        for(WashingMachine washingMachine : allWashingMachines)
            if (washingMachine.getUsedBy().equals(login))
                myWashingMachines.add(washingMachine);

        List<ElectricityItem> allMyItems = new ArrayList<>();
        allMyItems.addAll(myElectricityItems);
        allMyItems.addAll(myConditioners);
        allMyItems.addAll(myKettles);
        allMyItems.addAll(myWashingMachines);
        
        req.setAttribute("allMyItems", allMyItems);
        return "my_devices.jsp";
    }
}
