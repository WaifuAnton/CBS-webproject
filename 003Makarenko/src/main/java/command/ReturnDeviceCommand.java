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

public class ReturnDeviceCommand implements Command {
    @Override
    public String execute(HttpServletRequest req) {
        int id = Integer.parseInt(req.getParameter("device_id"));
        String type = req.getParameter("device_type");
        String name = req.getParameter("device_name");

        switch (type) {
            case "Conditioner":
                ConditionerHelper conditionerHelper = new ConditionerHelper();
                Conditioner conditioner = conditionerHelper.getById(id);
                conditioner.setUsedBy("none");
                conditionerHelper.update(id, conditioner);
                break;

            case "Kettle":
                KettleHelper kettleHelper = new KettleHelper();
                Kettle kettle = kettleHelper.getById(id);
                kettle.setUsedBy("none");
                kettleHelper.update(id, kettle);
                break;

            case "WashingMachine":
                WashingMachineHelper washingMachineHelper = new WashingMachineHelper();
                WashingMachine washingMachine = washingMachineHelper.getById(id);
                washingMachine.setUsedBy("none");
                washingMachineHelper.update(id, washingMachine);
                break;

            default:
                ElectricityItemHelper helper = new ElectricityItemHelper();
                ElectricityItem item = helper.getById(id);
                item.setUsedBy("none");
                helper.update(id, item);
        }
        return "controller?action=main";
    }
}
