package observer;

import java.util.ArrayList;
import java.util.List;

public class Weather implements Subject {

    private List<Observer> observers = new ArrayList<Observer>();
    
    private String status;
    
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(status);
        }
    }

    public void setStatus(String status) {
        this.status = status;
        notifyObservers();
    }

}
