package E02VehiclesExtension;

public class Bus extends Vehicle {
    private static final boolean DEFAULT_IS_EMPTY = true;
    private boolean isEmpty;

    public Bus(double fuelQuantity, double consumptionLitersPerKilometer, double tankCapacity) {
        super(fuelQuantity, consumptionLitersPerKilometer, tankCapacity);
        setIsEmpty(DEFAULT_IS_EMPTY);
    }

    public void setIsEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    @Override
    public void setConsumptionLitersPerKilometer(double consumptionLitersPerKilometer) {
        if (!this.isEmpty) {
            super.setConsumptionLitersPerKilometer(consumptionLitersPerKilometer + 1.4);
        }
    }

    @Override
    public String drive(double distance) {
        return "Bus " + super.drive(distance);
    }
}
