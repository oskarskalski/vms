package pl.oskarskalski.vms.vehicle;

import pl.oskarskalski.vms.model.*;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class VehicleConverter {
    public List<Vehicle> converterToObjects(List<String[]> data) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        List<Vehicle> vehicles = new ArrayList<>();

        for (String[] values : data) {
            values[0] = values[0].replace("[", "");
            VehicleMapper vehicleMapper;
            switch (values[0]){
                case "Vehicle":
                    vehicleMapper = new VehicleMapper<Vehicle>();
                    vehicles.add((Vehicle)vehicleMapper.mapToObject(new Vehicle(), values));
                    break;
                case "Bike":
                    vehicleMapper = new VehicleMapper<Bike>();
                    vehicles.add((Bike) vehicleMapper.mapToObject(new Bike(), values));
                    break;
                case "Motorcycle":
                    vehicleMapper = new VehicleMapper<Motorcycle>();
                    vehicles.add((Motorcycle)vehicleMapper.mapToObject(new Motorcycle(), values));
                    break;
                case "Car":
                    vehicleMapper = new VehicleMapper<Car>();
                    vehicles.add((Car)vehicleMapper.mapToObject(new Car(), values));
                    break;

            }
        }
        return vehicles;
    }

    public String[] convertToStrings(List<Vehicle> vehicles) {
        List<String> data = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            VehicleMapper vehicleMapper = null;
            String[] splitObjectName = vehicle.getClass().getName().split("\\.");
            String getClassName = splitObjectName[splitObjectName.length - 1];

            try {
                switch (getClassName) {
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
                String mappedString = vehicleMapper.mapToString(vehicle);
                data.add(mappedString);
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                System.out.println("Something went wrong with converting objects to data");
            }
        }
        return data.toArray(new String[0]);
    }
}
