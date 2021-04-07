package bakery.entities.bakedFoods.interfaces;

public class Bread extends BaseFood {
    private final static double INITIAL_BREAD_PORTION = 200;

    public Bread(String name, double price) {
        super(name, INITIAL_BREAD_PORTION, price);
    }
}
