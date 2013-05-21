package observer;

public interface Observable<T> {

    public void registerObserver(Observer<T> observer);
    
    public void unregisterObserver(Observer<T> observer);
    
    public void notifyObservers(T message);
    
}
