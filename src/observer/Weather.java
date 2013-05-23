package observer;

import java.util.ArrayList;
import java.util.List;

public class Weather implements Observable<String> {

    private List<Observer<String>> observers = new ArrayList<Observer<String>>();

    public void setStatus(String message) {
        notifyObservers(message);
    }

    @Override
    public void registerObserver(Observer<String> observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer<String> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer<String> observer : observers) {
            observer.update(message);
        }
    }

}
