package drawing;

import java.awt.Dimension;

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

    }

    /**
     * Test client
     * 
     * @param args
     */
    public static void main(String[] args) {

        new DrawingWindow();

    }

}
