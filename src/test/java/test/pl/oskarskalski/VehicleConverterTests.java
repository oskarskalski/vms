package test.pl.oskarskalski;

import org.junit.jupiter.api.Test;
import pl.oskarskalski.vms.model.Vehicle;
import pl.oskarskalski.vms.vehicle.VehicleConverter;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static test.pl.oskarskalski.TestData.*;

class VehicleConverterTests {
    private final VehicleConverter vehicleConverter = new VehicleConverter();

    @Test
    void givenListOfVehicleObjects__ExceptConvertedToStrings__ReturnedConvertedStrings() {
        List<Vehicle> vehicleList = new ArrayList<>();

        vehicleList.add(CAR_OBJECT_TEST_WITH_VALID_FIELDS);
        vehicleList.add(MOTORCYCLE_OBJECT_TEST_WITH_VALID_FIELDS);
        vehicleList.add(BIKE_OBJECT_TEST_WITH_VALID_FIELDS);
        vehicleList.add(VEHICLE_OBJECT_TEST_WITH_VALID_FIELDS);

        String[] convertedStrings = vehicleConverter.convertToStrings(vehicleList);

        assertAll(() -> assertEquals(CAR_TEXT_DATA, convertedStrings[0]),
                () -> assertEquals(MOTORCYCLE_TEXT_DATA, convertedStrings[1]),
                () -> assertEquals(BIKE_TEXT_DATA, convertedStrings[2]),
                () -> assertEquals(VEHICLE_TEXT_DATA, convertedStrings[3]));
    }

    @Test
    void givenListOfStringData__ExceptConvertedToObjects__ReturnedConvertedObjects() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        List<String[]> dataStrings = new ArrayList<>();

        dataStrings.add(CAR_TEXT_DATA.split(" "));
        dataStrings.add(MOTORCYCLE_TEXT_DATA.split(" "));
        dataStrings.add(BIKE_TEXT_DATA.split(" "));
        dataStrings.add(VEHICLE_TEXT_DATA.split(" "));

        List<Vehicle> vehicles = vehicleConverter.convertToObjects(dataStrings);
        Vehicle vehicle = vehicles.get(3);

        assertAll(() -> assertEquals(VEHICLE_BRAND_NAME, vehicle.getBrandName()),
                () -> assertEquals(VEHICLE_IS_ELECTRICAL, vehicle.isElectrical()),
                () -> assertEquals(VEHICLE_NUMBER_OF_SEATS, vehicle.getNumberOfSeats()),
                () -> assertEquals(VEHICLE_NUMBER_OF_TIRES, vehicle.getNumberOfTires()),
                () -> assertEquals(VEHICLE_TYPE, vehicle.getVehicleType()));
    }
}
