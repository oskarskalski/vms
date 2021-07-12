package test.pl.oskarskalski;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import pl.oskarskalski.vms.model.Bike;
import pl.oskarskalski.vms.model.Car;
import pl.oskarskalski.vms.model.Vehicle;
import pl.oskarskalski.vms.vehicle.VehicleMapper;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

class VehicleMapperTests {
    @Test
    void givenIsStringWithVehicleData__ExceptedMappedObject__ReturnedMappedObject() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        VehicleMapper<Vehicle> vehicleMapper = new VehicleMapper<>();
        String[] data = "Car tesla false null 600 1 2 4 400000 false false manual suv".split(" ");
        Car vehicle = (Car) vehicleMapper.mapToObject(new Car(), data);

        assertAll(() -> assertEquals(vehicle.getBrandName(), "tesla"),
                () -> assertEquals(vehicle.getNumberOfSeats(), 2),
                () -> assertEquals(vehicle.getNumberOfTires(), 4),
                //()-> assertEquals(vehicle.getVehicleType(), "a"),
                () -> assertFalse(vehicle.isElectrical()),
                () -> assertEquals(vehicle.getHorsePower(), 600));
    }

    @Test
    void givenIsObject__ExceptedDataString__ReturnedDataString() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Vehicle vehicle = new Vehicle("a", "b", 3, 2, false);
        VehicleMapper<Vehicle> vehicleMapper = new VehicleMapper<>();
        String data = vehicleMapper.mapToString(vehicle);

        assertEquals(data, "Vehicle b false 2 3 a");
    }
}
