package test.pl.oskarskalski;

import pl.oskarskalski.vms.model.Bike;
import pl.oskarskalski.vms.model.Car;
import pl.oskarskalski.vms.model.Motorcycle;
import pl.oskarskalski.vms.model.Vehicle;

class TestData {
    static final String VEHICLE_PREFIX = "Vehicle ";
    static final String BIKE_PREFIX = "Bike ";
    static final String MOTORCYCLE_PREFIX = "Motorcycle ";
    static final String CAR_PREFIX = "Car ";

    static final String VEHICLE_BRAND_NAME = "Kross";
    static final boolean VEHICLE_IS_ELECTRICAL = false;
    static final int VEHICLE_NUMBER_OF_SEATS = 1;
    static final int VEHICLE_NUMBER_OF_TIRES = 2;
    static final String VEHICLE_TYPE = "MTB";

    static final String BIKE_BRAND_NAME = "Trek";
    static final double BIKE_PRICE = 4000.0;
    static final boolean BIKE_IS_ELECTRICAL = true;
    static final int BIKE_NUMBER_OF_SEATS = VEHICLE_NUMBER_OF_SEATS;
    static final int BIKE_NUMBER_OF_TIRES = VEHICLE_NUMBER_OF_TIRES;
    static final String BIKE_TYPE = VEHICLE_TYPE;

    static final String MOTORCYCLE_BRAND_NAME = "Yamaha";
    static final String MOTORCYCLE_ENGINE_TYPE = "inline_4";
    static final int MOTORCYCLE_HORSE_POWER = 150;
    static final double MOTORCYCLE_MILEAGE = 1.0;
    static final int MOTORCYCLE_NUMBER_OF_SEATS = 2;
    static final int MOTORCYCLE_NUMBER_OF_TIRES = 2;
    static final double MOTORCYCLE_PRICE = 15000.0;
    static final String MOTORCYCLE_TRANSMISSION_TYPE = "manual";
    static final String MOTORCYCLE_TYPE = "street";
    static final boolean MOTORCYCLE_IS_ELECTRICAL = false;

    static final String CAR_BRAND_NAME = "Tesla";
    static final String CAR_ENGINE_TYPE = "3-phase_AC";
    static final boolean CAR_IS_ELECTRICAL = true;
    static final int CAR_HORSE_POWER = 400;
    static final double CAR_MILEAGE = 1.0;
    static final int CAR_NUMBER_OF_SEATS = 5;
    static final int CAR_NUMBER_OF_TIRES = 4;
    static final double CAR_PRICE = 300_000.0;
    static final String CAR_TRANSMISSION_TYPE = "automatic";
    static final String CAR_TYPE = "suv";
    static final boolean CAR_HAS_TOW_BAR = false;
    static final boolean CAR_HAS_ROOF_BIKE_RACK = false;

    static final String VEHICLE_TEXT_DATA = VEHICLE_PREFIX + VEHICLE_BRAND_NAME + " " + VEHICLE_IS_ELECTRICAL + " " +
            VEHICLE_NUMBER_OF_SEATS + " " + VEHICLE_NUMBER_OF_TIRES + " " + VEHICLE_TYPE;

    static final String BIKE_TEXT_DATA = BIKE_PREFIX + BIKE_BRAND_NAME + " " + BIKE_IS_ELECTRICAL + " " +
            BIKE_NUMBER_OF_SEATS + " " + BIKE_NUMBER_OF_TIRES + " " + BIKE_PRICE + " " + BIKE_TYPE;


    static final String MOTORCYCLE_TEXT_DATA = MOTORCYCLE_PREFIX + MOTORCYCLE_BRAND_NAME + " " + MOTORCYCLE_IS_ELECTRICAL +
            " " + MOTORCYCLE_ENGINE_TYPE + " " + +MOTORCYCLE_HORSE_POWER + " " + MOTORCYCLE_MILEAGE + " " + MOTORCYCLE_NUMBER_OF_SEATS + " " +
            MOTORCYCLE_NUMBER_OF_TIRES + " " + MOTORCYCLE_PRICE + " " + MOTORCYCLE_TRANSMISSION_TYPE + " " + MOTORCYCLE_TYPE;

    static final String CAR_TEXT_DATA = CAR_PREFIX + CAR_BRAND_NAME + " " + CAR_IS_ELECTRICAL + " " + CAR_ENGINE_TYPE + " " +
            CAR_HORSE_POWER + " " + CAR_MILEAGE + " " + CAR_NUMBER_OF_SEATS + " " + CAR_NUMBER_OF_TIRES + " " +
            CAR_PRICE + " " + CAR_HAS_TOW_BAR + " " + CAR_HAS_ROOF_BIKE_RACK + " " + CAR_TRANSMISSION_TYPE + " " + CAR_TYPE;


    static final Car CAR_OBJECT_TEST_WITH_NULL_FIELDS = new Car();
    static final Motorcycle MOTORCYCLE_OBJECT_TEST_WITH_NULL_FIELDS = new Motorcycle();
    static final Bike BIKE_OBJECT_TEST_WITH_NULL_FIELDS = new Bike();
    static final Vehicle VEHICLE_OBJECT_TEST_WITH_NULL_FIELDS = new Vehicle();

    static final Car CAR_OBJECT_TEST_WITH_VALID_FIELDS =
            new Car("Suv", "Tesla", 4,
                    5, true, 400000.0, "automatic", null, 400,
                    1.0, false, false);

    static final Motorcycle MOTORCYCLE_OBJECT_TEST_WITH_VALID_FIELDS =
            new Motorcycle("Street", "Yamaha", 4, 2, false, 4000,
                    "manual", "inline_4", 150, 1.0);

    static final Bike BIKE_OBJECT_TEST_WITH_VALID_FIELDS =
            new Bike();
    static final Vehicle VEHICLE_OBJECT_TEST_WITH_VALID_FIELDS = new Vehicle();

}