package pl.oskarskalski.vms.vehicle;

import pl.oskarskalski.vms.feature.ObjectMethods;
import pl.oskarskalski.vms.feature.UserInput;
import pl.oskarskalski.vms.model.Vehicle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;


public class VehiclePrinter {
    private final List<Vehicle> vehicles;

    public VehiclePrinter(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void printById() {
        UserInput userInput = new UserInput();
        int id = Integer.parseInt(userInput.getValueFromUser("Type id of the vehicle(Starts from 0)"));
        try {
            printInformation(vehicles.get(id));
        } catch (NullPointerException nullPointerException) {
            System.out.println("Element with this id doesn't exist");
        }
    }

    public void printAll() {
        for (Vehicle vehicle : vehicles) {
            printInformation(vehicle);
        }
    }

    public void printInformation(Vehicle vehicle) {
        if (vehicles.size() == 0) {
            System.out.println("There are no vehicles in the application");
        } else {
            String[] splitNames = vehicle.getClass().getName().split("\\.");
            String className = splitNames[splitNames.length - 1];

            ObjectMethods methods = new ObjectMethods();
            VehicleMethods vehicleXYZ = new VehicleMethods(className);
            String[] getters = vehicleXYZ.getGettersNames();

            System.out.println(className + ": ");
            for (String method : getters) {
                String methodName = methods.getMethodName(method);
                try {
                    Method getMethod = vehicle.getClass().getMethod(methodName);
                    System.out.println("\t" + methodName + " = " + getMethod.invoke(vehicle));
                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                    System.out.println("something went wrong with printer");
                }
            }
        }
    }
}
