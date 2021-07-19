package pl.oskarskalski.vms.vehicle;

import pl.oskarskalski.vms.feature.UserInput;
import pl.oskarskalski.vms.model.*;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class VehicleCreator {
    public Vehicle create() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        UserInput userInput = new UserInput();
        String className = userInput
                .getValueFromUser("Which object do you want to create?" +
                        " Type 'Vehicle', 'Bike', 'Motorcycle', 'Car'");

        String[] classMethods;
        VehicleMethods vehicleXYZ = new VehicleMethods(className);
        classMethods = vehicleXYZ.getSettersNames();

        StringBuilder data = new StringBuilder();
        data.append(className);
        System.out.println("Write values which are correctly to the type in the brackets. " +
                "For example (boolean) you can write true/false. " +
                "Otherwise variable's going to be replaces with default value");
        for (String method : classMethods) {
            data.append(" ");
            String value = userInput.getValueFromUser(method.substring(3));
            if(value == null || value.equals("")){
                data.append(0);
            }else{
                if(value.contains(" "))
                    value = value.replace(" ", "_");
                data.append(value);
            }
        }
        System.out.println(data.toString());
        VehicleConverter vehicleConverter = new VehicleConverter();
        List<String[]> dataList = new ArrayList<>();
        dataList.add(data.toString().split(" "));

        return vehicleConverter.convertToObjects(dataList).get(0);
    }
}
