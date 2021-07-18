package pl.oskarskalski.vms.vehicle;

import pl.oskarskalski.vms.feature.Methods;
import pl.oskarskalski.vms.feature.UserInput;
import pl.oskarskalski.vms.model.*;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class CreateVehicle {
    public Vehicle create() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        UserInput userInput = new UserInput();
        String className = userInput
                .getValueFromUser("Which object do you want to create?" +
                        " Type 'Vehicle', 'Bike', 'Motorcycle', 'Car'");

        String[] classMethods;

        switch (className) {
            case "Vehicle":
                Methods<Vehicle> vehicleMethods = new Methods<>();
                classMethods = vehicleMethods.getSetters(new Vehicle());
                break;
            case "Bike":
                Methods<Bike> bikeMethods = new Methods<>();
                classMethods = bikeMethods.getSetters(new Bike());
                break;
            case "Motorcycle":
                Methods<Motorcycle> motorcycleMethods = new Methods<>();
                classMethods = motorcycleMethods.getSetters(new Motorcycle());
                break;
            case "Car":
                Methods<Car> carMethods = new Methods<>();
                classMethods = carMethods.getSetters(new Car());
                break;
            default:
                System.out.println("Wrong name of vehicle");
                return null;
        }
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
        return vehicleConverter.converterToObjects(dataList).get(0);
    }
}
