package drawing;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import observer.Observable;
import observer.Observer;

public class Canvas extends JPanel implements Observer<MouseEvent>,
        Observable<MouseEvent> {

    private static final long serialVersionUID = 1L;

    private static List<Observer<MouseEvent>> observers = new ArrayList<Observer<MouseEvent>>();

    public Canvas() {
        setBackground(new Color(80000000));

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                notifyObservers(e);
                super.mouseDragged(e);
            }
        });

        registerObserver(this);
    }

    @Override
    public void registerObserver(Observer<MouseEvent> observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer<MouseEvent> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(MouseEvent e) {
        for (Observer<MouseEvent> observer : observers) {
            observer.update(e);
        }
    }

    @Override
    public void update(MouseEvent e) {
        getGraphics().fillArc(e.getX(), e.getY(), 5, 5, 0, 360);
    }

}
