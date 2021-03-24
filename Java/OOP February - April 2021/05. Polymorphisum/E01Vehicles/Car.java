package E01Vehicles;

public class Car extends Vehicle{


    public Car(double fuelQuantity, double consumptionLitersPerKilometer) {
        super(fuelQuantity, consumptionLitersPerKilometer);
    }

    @Override
    public void setConsumptionLitersPerKilometer(double consumptionLitersPerKilometer) {
        super.setConsumptionLitersPerKilometer(consumptionLitersPerKilometer + 0.9);
    }

    @Override
    public String drive(double distance) {
        return "Car " + super.drive(distance);
    }
}
