package pl.oskarskalski.vms.vehicle;

import pl.oskarskalski.vms.model.*;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class VehicleConverter {
    public List<Vehicle> convertToObjects(List<String[]> data) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        List<Vehicle> vehicles = new ArrayList<>();
        String modalsPackageName = Vehicle.class.getName().replace(".Vehicle", "");
        for (String[] values : data) {
            values[0] = values[0].replace("[", "");
            VehicleMapper vehicleMapper = getVehicleMapper(values[0]);
            Object vehicleClass = null;
            try {
                 vehicleClass = Class.forName(modalsPackageName + values[0]).getConstructor().newInstance();
            } catch (InstantiationException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            vehicleClass.getClass().getConstructor().getDeclaringClass();
            vehicles.add((Vehicle) vehicleMapper.mapToObject(vehicleClass, values));

        }
        return vehicles;
    }

    public String[] convertToStrings(List<Vehicle> vehicles) {
        List<String> data = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            String[] splitObjectName = vehicle.getClass().getName().split("\\.");
            String getClassName = splitObjectName[splitObjectName.length - 1];

            try {
                VehicleMapper vehicleMapper = getVehicleMapper(getClassName);
                String mappedString = vehicleMapper.mapToString(vehicle);
                data.add(mappedString);
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                System.out.println("Something went wrong with converting objects to data");
            }
        }
        return data.toArray(new String[0]);
    }

    private VehicleMapper getVehicleMapper(String vehicleName){
        VehicleMapper vehicleMapper = null;
        switch (vehicleName) {
            case "Vehicle":
                vehicleMapper = new VehicleMapper<Vehicle>();
                break;
            case "Bike":
                vehicleMapper = new VehicleMapper<Bike>();
                break;
            case "Motorcycle":
                vehicleMapper = new VehicleMapper<Motorcycle>();
                break;
            case "Car":
                vehicleMapper = new VehicleMapper<Car>();
                break;
        }
        return vehicleMapper;
    }
}

