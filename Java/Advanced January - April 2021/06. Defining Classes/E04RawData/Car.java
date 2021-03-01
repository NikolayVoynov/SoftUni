package E04RawData;

public class Car {

    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tier[] tiers;

    public Car(String model, Engine engine, Cargo cargo, Tier[] tiers) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tiers = tiers;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Engine getEngine() {
        return engine;
    }

    public String getModel() {
        return model;
    }

    public Tier[] getTiers() {
        return tiers;
    }

    public boolean hasTireUnderPressureOne() {
        for (Tier tier : tiers) {
            if (tier.getPressure() < 1) {
                return true;
            }
        }
        return false;
    }
}
