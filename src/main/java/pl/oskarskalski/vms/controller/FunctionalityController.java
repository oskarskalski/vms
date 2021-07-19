package pl.oskarskalski.vms.controller;

import pl.oskarskalski.vms.feature.FileOperations;
import pl.oskarskalski.vms.feature.UserInput;
import pl.oskarskalski.vms.model.*;
import pl.oskarskalski.vms.vehicle.CreateVehicle;
import pl.oskarskalski.vms.vehicle.VehicleConverter;
import pl.oskarskalski.vms.vehicle.VehiclePrinter;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class FunctionalityController {
    private List<Vehicle> vehicles;
    private final FileOperations fileOperations = new FileOperations();

    public void controller(int option) {
        switch (option) {
            case 1:
                List<String[]> data = null;
                try {
                    data = fileOperations.read();
                } catch (IOException e) {
                    System.out.println("Something went wrong!");
                }
                VehicleConverter vehicleConverter = new VehicleConverter();
                try {
                    if (data != null) {
                        vehicles = vehicleConverter.convertToObjects(data);
                    } else {
                        System.out.println("There's no data to create objects");
                    }
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    System.out.println("Something went wrong with loading data.");
                }
                break;
            case 2:
                fileOperations.saveDataToFile(vehicles);
                break;
            case 3:
                VehiclePrinter vehiclePrinter = new VehiclePrinter(vehicles);
                vehiclePrinter.printById();
                break;
            case 4:
                vehiclePrinter = new VehiclePrinter(vehicles);
                vehiclePrinter.printAll();
                break;
            case 5:
                CreateVehicle createVehicle = new CreateVehicle();
                try {
                    Vehicle vehicle = createVehicle.create();
                    if(vehicles == null){
                        vehicles = new ArrayList<>();
                    }
                    vehicles.add(vehicle);
                } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                    System.out.println("Something went wrong");
                }
                break;
            case 6:
                UserInput userInput = new UserInput();
                try{
                    int vehicleId = Integer.parseInt(
                            userInput.getValueFromUser("Type id of the vehicle"));
                    if(vehicleId >= 0 && vehicleId < vehicles.size()){
                        vehicles.remove(vehicleId);
                    }else{
                        System.out.println("Vehicle of this id doesn't exist");
                    }
                }catch (NumberFormatException e){
                    System.out.println("Wrong number, try again!");
                }
                break;
            default:
                System.out.println("There's  no operation for that. Try again!");
        }
    }
}
