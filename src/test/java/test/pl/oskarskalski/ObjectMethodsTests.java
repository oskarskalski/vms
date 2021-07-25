package test.pl.oskarskalski;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import pl.oskarskalski.vms.feature.ObjectMethods;
import pl.oskarskalski.vms.model.Vehicle;

class ObjectMethodsTests {
    @Test
    void givenVehicleObject__ExceptedArrayOfGetterMethods__ReturnedArrayOfGetterMethods() {
        Vehicle vehicle = new Vehicle();
        ObjectMethods<Vehicle> objectMethods = new ObjectMethods<>();
        String[] getters = objectMethods.getGetterMethods(vehicle);
        assertEquals(5, getters.length);
    }

    @Test
    void givenVehicleObject__ExceptedArrayOfSettersMethods__ReturnedArrayOfSettersMethods() {
        Vehicle vehicle = new Vehicle();
        ObjectMethods<Vehicle> objectMethods = new ObjectMethods<>();
        String[] setters = objectMethods.getSetterMethods(vehicle);
        assertEquals(5, setters.length);
    }

    @Test
    void givenGetter__ExceptedGetterName__ReturnedGetterName() {
        ObjectMethods<Vehicle> objectMethods = new ObjectMethods<>();
        String method = "getVehicleType()";
        String methodName = objectMethods.getMethodName(method);
        assertEquals("getVehicleType", methodName);
    }

    @Test
    void givenSetter__ExceptedSetterName__ReturnedSetterName() {
        ObjectMethods<Vehicle> objectMethods = new ObjectMethods<>();
        String method = "setVehicleType(String vehicleType)";
        String methodName = objectMethods.getMethodName(method);
        assertEquals("setVehicleType", methodName);
    }
    @Test
    void givenSetter__ExceptedSetterParamType__ReturnedSetterParamType() {
        ObjectMethods<Vehicle> objectMethods = new ObjectMethods<>();
        String method = "setVehicleType(String)";
        String methodName = objectMethods.getMethodParamType(method);
        assertEquals("String", methodName);
    }
}
