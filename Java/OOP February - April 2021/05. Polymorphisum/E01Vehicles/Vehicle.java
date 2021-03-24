package E01Vehicles;

import java.text.DecimalFormat;

public class Vehicle implements IVehicle {
    public double fuelQuantity;
    private double consumptionLitersPerKilometer;

    public Vehicle(double fuelQuantity, double consumptionLitersPerKilometer) {
        setFuelQuantity(fuelQuantity);
        setConsumptionLitersPerKilometer(consumptionLitersPerKilometer);
    }

    public void setConsumptionLitersPerKilometer(double consumptionLitersPerKilometer) {
        this.consumptionLitersPerKilometer = consumptionLitersPerKilometer;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    @Override
    public String drive(double distance) {
        double neededFuel = distance * this.consumptionLitersPerKilometer;

        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        String result = "needs refueling";

        if (this.fuelQuantity >= neededFuel) {
            this.fuelQuantity -= neededFuel;
            result = String.format("travelled %s km", decimalFormat.format(distance));
        }

        return result;
    }

    @Override
    public void refuel(double fuel) {
        this.fuelQuantity += fuel;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
