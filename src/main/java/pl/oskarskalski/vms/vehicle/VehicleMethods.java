package pl.oskarskalski.vms.vehicle;

import pl.oskarskalski.vms.feature.Methods;
import pl.oskarskalski.vms.model.Bike;
import pl.oskarskalski.vms.model.Car;
import pl.oskarskalski.vms.model.Motorcycle;
import pl.oskarskalski.vms.model.Vehicle;

import java.lang.reflect.InvocationTargetException;

public class VehicleMethods {
    private final static String modalPackageName = Vehicle.class.getName().replace("Vehicle", "");

    private Methods vehicleMethods;
    private String className;
    public VehicleMethods(String className){
        this.className = className;
        switch (className) {
            case "Vehicle":
                vehicleMethods = new Methods<Vehicle>();
                break;
            case "Bike":
                vehicleMethods = new Methods<Bike>();
                break;
            case "Motorcycle":
                vehicleMethods = new Methods<Motorcycle>();
                break;
            case "Car":
                vehicleMethods = new Methods<Car>();
                break;
            default:
                System.out.println("Wrong name of vehicle");
        }
    }

    public Object getObject(){
        Object vehicleClass = null;

        try {
            vehicleClass = Class.forName(modalPackageName + className).getConstructor().newInstance();
        } catch (InstantiationException | ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return vehicleClass;
    }

    public String[] getGettersNames(){
        String[] getters = vehicleMethods.getGetters(getObject());

        return getters;
    }
    public String[] getSettersNames(){
        String[] setters = vehicleMethods.getSetters(getObject());

        return setters;
    }
}
