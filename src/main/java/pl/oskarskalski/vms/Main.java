package pl.oskarskalski.vms;

import pl.oskarskalski.vms.controller.ApplicationController;

public class Main {

    public static void main(String[] args) {
        ApplicationController applicationController = new ApplicationController();
        applicationController.controller();
    }
}