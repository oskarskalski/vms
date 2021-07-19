package pl.oskarskalski.vms.model;

public class Vehicle{
    private String vehicleType;
    private String brandName;
    private int numberOfTires;
    private int numberOfSeats;
    private boolean electrical;

    public Vehicle(String vehicleType, String brandName, int numberOfTires, int numberOfSeats, boolean electrical) {
        this.vehicleType = vehicleType;
        this.brandName = brandName;
        this.numberOfTires = numberOfTires;
        this.numberOfSeats = numberOfSeats;
        this.electrical = electrical;
    }

    public Vehicle() {
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getNumberOfTires() {
        return numberOfTires;
    }

    public void setNumberOfTires(int numberOfTires) {
        this.numberOfTires = numberOfTires;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public boolean isElectrical() {
        return electrical;
    }

    public void setElectrical(boolean electrical) {
        this.electrical = electrical;
    }
}
