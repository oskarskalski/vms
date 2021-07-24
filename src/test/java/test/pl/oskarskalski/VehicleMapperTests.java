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

class VehicleMapperTests {
    @Test
    void givenIsStringWithVehicleData__ExceptedMappedObject__ReturnedMappedObject() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        VehicleMapper<Vehicle> vehicleMapper = new VehicleMapper<>();
        String[] data = VEHICLE_TEXT_DATA.split(" ");
        Vehicle vehicle = vehicleMapper.mapToObject(new Vehicle(), data);

        assertAll(() -> assertEquals(VEHICLE_BRAND_NAME, vehicle.getBrandName()),
                () -> assertEquals(VEHICLE_NUMBER_OF_SEATS, vehicle.getNumberOfSeats()),
                () -> assertEquals(VEHICLE_NUMBER_OF_TIRES, vehicle.getNumberOfTires()),
                () -> assertEquals(VEHICLE_TYPE, vehicle.getVehicleType()),
                () -> assertEquals(VEHICLE_IS_ELECTRICAL, vehicle.isElectrical()));
    }

    @Test
    void givenIsStringWithBikeData__ExceptedMappedObject__ReturnedMappedObject() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        VehicleMapper<Bike> vehicleMapper = new VehicleMapper<>();
        String[] data = BIKE_TEXT_DATA.split(" ");
        Bike vehicle = vehicleMapper.mapToObject(new Bike(), data);

        assertAll(() -> assertEquals(BIKE_BRAND_NAME, vehicle.getBrandName()),
                () -> assertEquals(BIKE_NUMBER_OF_SEATS, vehicle.getNumberOfSeats()),
                () -> assertEquals(BIKE_NUMBER_OF_TIRES, vehicle.getNumberOfTires()),
                () -> assertEquals(BIKE_TYPE, vehicle.getVehicleType()),
                () -> assertEquals(BIKE_PRICE, vehicle.getPrice()),
                () -> assertEquals(BIKE_PRICE, vehicle.getPrice()));
    }

    @Test
    void givenIsStringWithMotorcycleData__ExceptedMappedObject__ReturnedMappedObject() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        VehicleMapper<Motorcycle> vehicleMapper = new VehicleMapper<>();
        String[] data = MOTORCYCLE_TEXT_DATA.split(" ");
        Motorcycle vehicle = vehicleMapper.mapToObject(new Motorcycle(), data);

        assertAll(() -> assertEquals(MOTORCYCLE_BRAND_NAME, vehicle.getBrandName()),
                () -> assertEquals(MOTORCYCLE_NUMBER_OF_SEATS, vehicle.getNumberOfSeats()),
                () -> assertEquals(MOTORCYCLE_NUMBER_OF_TIRES, vehicle.getNumberOfTires()),
                () -> assertEquals(MOTORCYCLE_TYPE, vehicle.getVehicleType()),
                () -> assertEquals(MOTORCYCLE_PRICE, vehicle.getPrice()),
                () -> assertEquals(MOTORCYCLE_TRANSMISSION_TYPE, vehicle.getTransmissionsType()),
                () -> assertEquals(MOTORCYCLE_ENGINE_TYPE, vehicle.getEngineType()),
                () -> assertEquals(MOTORCYCLE_HORSE_POWER, vehicle.getHorsePower()),
                () -> assertEquals(MOTORCYCLE_MILEAGE, vehicle.getMileage()),
                () -> assertEquals(MOTORCYCLE_IS_ELECTRICAL, vehicle.isElectrical()));
    }

    @Test
    void givenIsStringWithCarData__ExceptedMappedObject__ReturnedMappedObject() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        VehicleMapper<Car> vehicleMapper = new VehicleMapper<>();
        String[] data = CAR_TEXT_DATA.split(" ");
        Car vehicle = vehicleMapper.mapToObject(new Car(), data);

        assertAll(() -> assertEquals(CAR_BRAND_NAME, vehicle.getBrandName()),
                () -> assertEquals(CAR_NUMBER_OF_SEATS, vehicle.getNumberOfSeats()),
                () -> assertEquals(CAR_NUMBER_OF_TIRES, vehicle.getNumberOfTires()),
                () -> assertEquals(CAR_TYPE, vehicle.getVehicleType()),
                () -> assertEquals(CAR_PRICE, vehicle.getPrice()),
                () -> assertEquals(CAR_TRANSMISSION_TYPE, vehicle.getTransmissionsType()),
                () -> assertEquals(CAR_ENGINE_TYPE, vehicle.getEngineType()),
                () -> assertEquals(CAR_HAS_ROOF_BIKE_RACK, vehicle.hasRoofBikeRack()),
                () -> assertEquals(CAR_HAS_TOW_BAR, vehicle.hasTowBar()),
                () -> assertEquals(CAR_HORSE_POWER, vehicle.getHorsePower()),
                () -> assertEquals(CAR_MILEAGE, vehicle.getMileage()),
                () -> assertEquals(CAR_IS_ELECTRICAL, vehicle.isElectrical()));
    }

    @Test
    void givenIsStringWithVehicleInvalidData__ExceptedMappedObject__ReturnedMappedObject() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        VehicleMapper<Vehicle> vehicleMapper = new VehicleMapper<>();
        String[] data = VEHICLE_TEXT_DATA.substring(0, VEHICLE_TEXT_DATA.length() - 4).split(" ");
        Vehicle vehicle = vehicleMapper.mapToObject(new Vehicle(), data);

        assertAll(() -> assertEquals(VEHICLE_BRAND_NAME, vehicle.getBrandName()),
                () -> assertEquals(VEHICLE_NUMBER_OF_SEATS, vehicle.getNumberOfSeats()),
                () -> assertEquals(VEHICLE_NUMBER_OF_TIRES, vehicle.getNumberOfTires()),
                () -> assertEquals(VEHICLE_IS_ELECTRICAL, vehicle.isElectrical()),
                () -> assertNull(vehicle.getVehicleType()));
    }

    @Test
    void givenIsStringWithoutData__ExceptedMappedObject__ReturnedMappedObject() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        VehicleMapper<Vehicle> vehicleMapper = new VehicleMapper<>();
        String data[] = {VEHICLE_PREFIX};
        Vehicle vehicle = vehicleMapper.mapToObject(new Vehicle(), data);

        assertAll(() -> assertNull(vehicle.getBrandName()),
                () -> assertNull(vehicle.getVehicleType()),
                () -> assertEquals(0, vehicle.getNumberOfSeats()),
                () -> assertEquals(0, vehicle.getNumberOfTires()),
                () -> assertFalse(vehicle.isElectrical()));
    }

    @Test
    void givenIsObject__ExceptedMappedString__ReturnedMappedString() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        VehicleMapper<Vehicle> vehicleMapper = new VehicleMapper<>();
        String vehicleString = vehicleMapper.mapToString(CAR_OBJECT_TEST_WITH_VALID_FIELDS);

        assertEquals(CAR_TEXT_DATA, vehicleString);
    }
}
