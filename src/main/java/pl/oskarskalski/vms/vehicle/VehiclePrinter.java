package pl.oskarskalski.vms.vehicle;

import pl.oskarskalski.vms.feature.Methods;
import pl.oskarskalski.vms.feature.UserInput;
import pl.oskarskalski.vms.model.Bike;
import pl.oskarskalski.vms.model.Car;
import pl.oskarskalski.vms.model.Motorcycle;
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

            Methods methods = null;
            String[] getters = null;

            switch (className) {
                case "Vehicle":
                    methods = new Methods<Vehicle>();
                    getters = methods.getGetters(new Vehicle());
                    break;
                case "Bike":
                    methods = new Methods<Bike>();
                    getters = methods.getGetters(new Bike());
                    break;
                case "Motorcycle":
                    methods = new Methods<Motorcycle>();
                    getters = methods.getGetters(new Motorcycle());
                    break;
                case "Car":
                    methods = new Methods<Car>();
                    getters = methods.getGetters(new Car());
                    break;
            }
            System.out.println(className + ": ");
            for (String method : getters) {
                try {
                    String methodName = methods.getMethodName(method);
                    Method getMethod = vehicle.getClass().getMethod(methodName);
                    System.out.println("\t" + methodName + " = " + getMethod.invoke(vehicle));
                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                    System.out.println("something went wrong with printer");
                }
            }
        }
    }
}
