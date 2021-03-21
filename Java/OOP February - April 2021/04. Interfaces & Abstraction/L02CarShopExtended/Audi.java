package L02CarShopExtended;

public class Audi extends CarImpl implements Rentable {

    private Integer rentPerDay;
    private Double pricePerDay;

    public Audi(String model, String color, Integer horsePower,
                String countryProduced, Integer rentPerDay, Double pricePerDay) {

        super(model, color, horsePower, countryProduced);
        this.rentPerDay = rentPerDay;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public Integer getMinRentDay() {
        return this.rentPerDay;
    }

    @Override
    public Double getPricePerDay() {
        return this.pricePerDay;
    }

    @Override
    public String toString() {
        return String.format("%s%nMinimum rental period of %d days. Price per day %f",
                super.toString(), this.getMinRentDay(), this.getPricePerDay());
    }
}
