package E04FoodShortage;

public class Rebel implements Person, Buyer {

    private static final int INCREASE_FOOD_BY_FIVE = 5;

    private String name;
    private int age;
    private String group;
    private int food;

    public Rebel(String name, int age, String group) {
        this.setName(name);
        this.setAge(age);
        this.setGroup(group);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public int getFood() {
        return this.food;
    }

    @Override
    public void buyFood() {
        this.increaseFood(INCREASE_FOOD_BY_FIVE);
    }

    private void increaseFood(int amount) {
        this.food += amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
