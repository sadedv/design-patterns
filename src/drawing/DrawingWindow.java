package drawing;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;

public class DrawingWindow extends JFrame {

    private static final long serialVersionUID = 1L;

    public DrawingWindow() {

        init();
        setVisible(true);

    }

    private void init() {

        // Set window size
        setSize(new Dimension(400, 300));

        // Set default close operation
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Add new panel
        add(new Canvas());

        // Set title
        setTitle("Drawing #" + Thread.currentThread().getId());

    }

    /**
     * Test client
     * 
     * @param args
     */
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DrawingWindow();
            }
        });

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DrawingWindow();
            }
        });

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DrawingWindow();
            }
        });

    }

}
