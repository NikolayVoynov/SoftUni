package observerPattern;

import java.util.ArrayList;
import java.util.List;

public class Subject implements ISubject {
    private List<IObserver> observers;
    private String state;

    public Subject() {
        this.observers = new ArrayList<>();
        this.state = "INITIAL";
    }

    @Override
    public void registerObserver(IObserver observer) {
        if (observer != null) {
            observers.add(observer);
        }

    }

    @Override
    public void removeObserver(IObserver observer) {
        if (observers.remove(observer)) {
            System.out.println(String.format("%s successfully removed!", observer));
        }

    }

    @Override
    public void notifyObservers() {
        observers.forEach(IObserver::update);
    }

    @Override
    public void changeState(String newState) {
        this.state = newState;
        notifyObservers();
    }
}
