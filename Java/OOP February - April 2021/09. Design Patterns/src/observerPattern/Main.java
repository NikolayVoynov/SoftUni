package observerPattern;

public class Main {
    public static void main(String[] args) {
        ISubject site = new Subject();

        IObserver Nikolay = new Observer();
        IObserver Monika = new Observer();

        site.registerObserver(Nikolay);
        site.registerObserver(Monika);

        site.changeState("Breaking News!!!");
    }
}
