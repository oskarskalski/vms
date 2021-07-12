package pl.oskarskalski.vms;

import pl.oskarskalski.vms.controller.ApplicationController;
import pl.oskarskalski.vms.model.Vehicle;
import pl.oskarskalski.vms.vehicle.CreateVehicle;
import pl.oskarskalski.vms.vehicle.VehicleMapper;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ApplicationController applicationController = new ApplicationController();
        applicationController.controller();
    }
}