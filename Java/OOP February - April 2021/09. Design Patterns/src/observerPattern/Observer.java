package observerPattern;

public class Observer implements IObserver{
    @Override
    public void update() {
        System.out.println("Hi, there is an update!");
    }
}
