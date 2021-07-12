package pl.oskarskalski.vms.model;

public class Motorcycle extends Bike{
    private String transmissionsType;
    private String engineType;
    private int horsePower;
    private double mileage;

    public Motorcycle(String vehicleType, String brandName, int numberOfTires, int numberOfSeats, boolean electrical, double price,
                      String transmissionsType, String engineType, int horsePower, double mileage) {
        super(vehicleType, brandName, numberOfTires, numberOfSeats, electrical, price);

        this.transmissionsType = transmissionsType;
        this.engineType = engineType;
        this.horsePower = horsePower;
        this.mileage = mileage;
    }

    public Motorcycle(){}

    public String getTransmissionsType() {
        return transmissionsType;
    }

    public void setTransmissionsType(String transmissionsType) {
        this.transmissionsType = transmissionsType;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    @Override
    public String printInformation() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.printInformation());

        sb.append("\tTransmission type = ");
        sb.append(transmissionsType);
        sb.append("\n");

        sb.append("\tEngine type = ");
        sb.append(transmissionsType);
        sb.append("\n");

        sb.append("\tHorse power= ");
        sb.append(horsePower);
        sb.append("\n");

        sb.append("\tMileage = ");
        sb.append(mileage);
        sb.append("\n");

        return sb.toString();
    }
}
