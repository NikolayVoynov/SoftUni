package E02VehiclesExtension;

import java.text.DecimalFormat;

public class Vehicle implements IVehicle {
    private double fuelQuantity;
    private double consumptionLitersPerKilometer;
    private double tankCapacity;


    public Vehicle(double fuelQuantity, double consumptionLitersPerKilometer, double tankCapacity) {
        setFuelQuantity(fuelQuantity);
        setConsumptionLitersPerKilometer(consumptionLitersPerKilometer);
        this.tankCapacity = tankCapacity;
    }

    public void setConsumptionLitersPerKilometer(double consumptionLitersPerKilometer) {
        this.consumptionLitersPerKilometer = consumptionLitersPerKilometer;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity >= 0) {
            this.fuelQuantity = fuelQuantity;
        }

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
        if (fuel <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        } else if (fuel + this.fuelQuantity > this.tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.fuelQuantity += fuel;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
