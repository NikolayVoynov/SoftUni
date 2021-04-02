package factoryPattern;

public class PizzaFactory {

    public Pizza createPizza(PizzaType type, int diameter) {
        Pizza pizza = null;

        switch (type) {
            case ROME:
                pizza = new RomePizza(diameter);
                break;
            case VEGETARIAN:
                pizza = new VegetarianPizza(diameter);
                break;
            case MALIBU:
                pizza = new MalibuPizza(diameter);
                break;
            case QUATTROFORMAGGI:
                pizza = new QuattroFormaggiPizza(diameter);
                break;
        }

        return pizza;
    }
}
