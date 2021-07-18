package test.pl.oskarskalski;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static test.pl.oskarskalski.TestData.*;

import pl.oskarskalski.vms.model.Bike;
import pl.oskarskalski.vms.model.Car;
import pl.oskarskalski.vms.model.Motorcycle;
import pl.oskarskalski.vms.model.Vehicle;
import pl.oskarskalski.vms.vehicle.VehicleMapper;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

class VehicleMapperTests {
    @Test
    void givenIsStringWithVehicleData__ExceptedMappedObject__ReturnedMappedObject() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        VehicleMapper<Vehicle> vehicleMapper = new VehicleMapper<>();
        String[] data = vehicleTextData.split(" ");
        Vehicle vehicle = vehicleMapper.mapToObject(new Vehicle(), data);

        assertAll(() -> assertEquals(vehicle.getBrandName(), "Kross"),
                () -> assertEquals(vehicle.getNumberOfSeats(), 1),
                () -> assertEquals(vehicle.getNumberOfTires(), 2),
                ()-> assertEquals(vehicle.getVehicleType(), "MTB"),
                () -> assertFalse(vehicle.isElectrical()));
    }

    @Test
    void givenIsStringWithBikeData__ExceptedMappedObject__ReturnedMappedObject() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        VehicleMapper<Bike> vehicleMapper = new VehicleMapper<>();
        String[] data = bikeTextData.split(" ");
        Bike vehicle = vehicleMapper.mapToObject(new Bike(), data);

        assertAll(() -> assertEquals(vehicle.getBrandName(), "Trek"),
                () -> assertEquals(vehicle.getNumberOfSeats(), 1),
                () -> assertEquals(vehicle.getNumberOfTires(), 2),
                ()-> assertEquals(vehicle.getVehicleType(), "MTB"),
                ()-> assertEquals(vehicle.getPrice(), 4000.0),
                () -> assertFalse(vehicle.isElectrical()));
    }

    @Test
    void givenIsStringWithMotorcycleData__ExceptedMappedObject__ReturnedMappedObject() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        VehicleMapper<Motorcycle> vehicleMapper = new VehicleMapper<>();
        String[] data = motorcycleTextData.split(" ");
        Motorcycle vehicle = vehicleMapper.mapToObject(new Motorcycle(), data);

        assertAll(() -> assertEquals(vehicle.getBrandName(), "Yamaha"),
                () -> assertEquals(vehicle.getNumberOfSeats(), 2),
                () -> assertEquals(vehicle.getNumberOfTires(), 2),
                ()-> assertEquals(vehicle.getVehicleType(), "street"),
                ()-> assertEquals(vehicle.getPrice(), 15000.0),
                ()-> assertEquals(vehicle.getTransmissionsType(), "manual"),
                ()-> assertEquals(vehicle.getEngineType(), "inline_4"),
                ()-> assertEquals(vehicle.getHorsePower(), 150),
                ()-> assertEquals(vehicle.getMileage(), 1.0),
                () -> assertFalse(vehicle.isElectrical()));
    }

    @Test
    void givenIsStringWithCarData__ExceptedMappedObject__ReturnedMappedObject() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        VehicleMapper<Car> vehicleMapper = new VehicleMapper<>();
        String[] data = carTextData.split(" ");
        Car vehicle = vehicleMapper.mapToObject(new Car(), data);

        assertAll(() -> assertEquals(vehicle.getBrandName(), "Tesla"),
                () -> assertEquals(vehicle.getNumberOfSeats(), 5),
                () -> assertEquals(vehicle.getNumberOfTires(), 4),
                ()-> assertEquals(vehicle.getVehicleType(), "suv"),
                ()-> assertEquals(vehicle.getPrice(), 300000.0),
                ()-> assertEquals(vehicle.getTransmissionsType(), "automatic"),
                ()-> assertEquals(vehicle.getEngineType(), "null"),
                ()-> assertFalse(vehicle.hasRoofBikeRack()),
                ()-> assertFalse(vehicle.hasTowBar()),
                ()-> assertEquals(vehicle.getHorsePower(), 400),
                ()-> assertEquals(vehicle.getMileage(), 1.0),
                () -> assertTrue(vehicle.isElectrical()));
    }
}
