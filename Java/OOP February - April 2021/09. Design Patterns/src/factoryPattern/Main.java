package factoryPattern;

public class Main {
    public static void main(String[] args) {
        Pizzeria pizzeria = new Pizzeria(new PizzaFactory());
        pizzeria.orderPizza(PizzaType.ROME, 30);
        pizzeria.orderPizza(PizzaType.QUATTROFORMAGGI, 15);
    }
}
