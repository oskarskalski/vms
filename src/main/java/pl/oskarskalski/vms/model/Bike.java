package pl.oskarskalski.vms.model;

public class Bike extends Vehicle {
    private double price;

    public Bike(String vehicleType, String brandName, int numberOfTires, int numberOfSeats, boolean electrical,
                double price) {
        super(vehicleType, brandName, numberOfTires, numberOfSeats, electrical);
        this.price = price;
    }

    public Bike(){}

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
