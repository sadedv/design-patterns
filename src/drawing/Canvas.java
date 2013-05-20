package drawing;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class Canvas extends JPanel {

    private static final long serialVersionUID = 1L;

    public Canvas() {

        setBackground(new Color(80000000));
        addMouseMotionListener(new MyMouseMotionListener());

    }

    class MyMouseMotionListener implements MouseMotionListener {

        @Override
        public void mouseDragged(MouseEvent e) {
            getGraphics().fillArc(e.getX(), e.getY(), 5, 5, 0, 360);
        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }

    }

}
