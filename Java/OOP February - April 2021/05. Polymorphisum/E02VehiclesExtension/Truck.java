package E02VehiclesExtension;

public class Truck extends Vehicle {


    public Truck(double fuelQuantity, double consumptionLitersPerKilometer, double tankCapacity) {
        super(fuelQuantity, consumptionLitersPerKilometer, tankCapacity);
    }

    @Override
    public void setConsumptionLitersPerKilometer(double consumptionLitersPerKilometer) {
        super.setConsumptionLitersPerKilometer(consumptionLitersPerKilometer + 1.6);
    }

    @Override
    public void refuel(double fuel) {
        super.refuel(fuel * 0.95);
    }

    @Override
    public String drive(double distance) {
        return "Truck " + super.drive(distance);
    }
}
