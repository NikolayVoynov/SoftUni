package E04RawData;

import java.util.List;
import java.util.Map;

public class Tier {

    private double pressure;
    private int age;

    public Tier(double pressure, int age) {
        this.pressure = pressure;
        this.age = age;
    }

    public double getPressure() {
        return this.pressure;
    }

}
