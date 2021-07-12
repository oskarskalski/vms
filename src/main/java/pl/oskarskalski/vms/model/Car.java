package pl.oskarskalski.vms.model;

public class Car extends Motorcycle{
    private boolean towBar;
    private boolean roofBikeRack;

    public Car(String vehicleType, String brandName, int numberOfTires, int numberOfSeats, boolean electrical,
               double price, String transmissionsType, String engineType, int horsePower, double mileage,
               boolean towBar, boolean roofBikeRack) {
        super(vehicleType, brandName, numberOfTires, numberOfSeats, electrical, price, transmissionsType,
                engineType, horsePower, mileage);

        this.towBar = towBar;
        this.roofBikeRack = roofBikeRack;
    }

    public Car(){}

    public boolean hasTowBar() {
        return towBar;
    }

    public void setTowBar(boolean towBar) {
        this.towBar = towBar;
    }

    public boolean hasRoofBikeRack() {
        return roofBikeRack;
    }

    public void setRoofBikeRack(boolean roofBikeRack) {
        this.roofBikeRack = roofBikeRack;
    }
}
