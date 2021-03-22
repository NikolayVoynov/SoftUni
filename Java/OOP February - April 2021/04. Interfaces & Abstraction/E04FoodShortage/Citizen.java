package E04FoodShortage;

public class Citizen implements Person, Identifiable, Buyer {

    private static final int INCREASE_FOOD_BY_TEN = 10;

    private String name;
    private int age;
    private String id;
    private String birthDate;
    private int food;

    public Citizen(String name, int age, String id, String birthDate) {
        this.setName(name);
        this.setAge(age);
        this.setId(id);
        this.setBirthDate(birthDate);
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
    public String getId() {
        return this.id;
    }

    @Override
    public int getFood() {
        return food;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    @Override
    public void buyFood() {
        this.increaseFood(INCREASE_FOOD_BY_TEN);
    }

    private void increaseFood(int quantity) {
        this.food += quantity;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private void setId(String id) {
        this.id = id;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

}
