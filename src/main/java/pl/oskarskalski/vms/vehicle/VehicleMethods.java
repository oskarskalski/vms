package pl.oskarskalski.vms.vehicle;

import pl.oskarskalski.vms.feature.ObjectMethods;
import pl.oskarskalski.vms.model.Bike;
import pl.oskarskalski.vms.model.Car;
import pl.oskarskalski.vms.model.Motorcycle;
import pl.oskarskalski.vms.model.Vehicle;

import java.lang.reflect.InvocationTargetException;

public class VehicleMethods {
    private final static String modalPackageName = Vehicle.class.getName().replace("Vehicle", "");

    private ObjectMethods vehicleMethods;
    private String className;
    public VehicleMethods(String className){
        this.className = className;
        switch (className) {
            case "Vehicle":
                vehicleMethods = new ObjectMethods<Vehicle>();
                break;
            case "Bike":
                vehicleMethods = new ObjectMethods<Bike>();
                break;
            case "Motorcycle":
                vehicleMethods = new ObjectMethods<Motorcycle>();
                break;
            case "Car":
                vehicleMethods = new ObjectMethods<Car>();
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
        String[] getters = vehicleMethods.getGetterMethods(getObject());

        return getters;
    }
    public String[] getSettersNames(){
        String[] setters = vehicleMethods.getSetterMethods(getObject());

        return setters;
    }
}
