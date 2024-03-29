package aquarium.entities.fish;

public class FreshwaterFish extends BaseFish{
    private static final int INITIAL_SIZE = 3;
    private int size;

    public FreshwaterFish(String name, String species, double price) {
        super(name, species, price);
        this.size = INITIAL_SIZE;
    }

    @Override
    public void eat() {
        this.size += 3;
    }
}
