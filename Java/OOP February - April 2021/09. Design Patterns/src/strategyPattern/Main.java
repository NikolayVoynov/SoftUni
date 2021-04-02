package strategyPattern;

public class Main {
    public static void main(String[] args) {
        Context context = new Context(new StrategyAdd());
        System.out.println(context.executeStrategy(4, 8));

        context = new Context(new StrategyMultiply());
        System.out.println(context.executeStrategy(2, 6));

        context = new Context(new StrategySubtract());
        System.out.println(context.executeStrategy(1, 5));
    }
}
