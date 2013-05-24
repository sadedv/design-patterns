package networking.multicast;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChatWindow extends JFrame {

    private static final long serialVersionUID = 1L;

    public ChatWindow() {

        // Setup
        setSize(new Dimension(800, 600));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Simple Chat Application");

        // Initialize components
        init();

    }

    private void init() {

        // Set group layout
        getContentPane().setLayout(new GroupLayout(getContentPane()));

        // Add main panel
        JPanel panel = new JPanel();
        panel.setSize(getContentPane().getWidth() - 10, getContentPane()
                .getHeight() - 10);
        panel.setLocation(5, 5);
        panel.setBackground(new Color(200, 200, 200));
        add(panel);

    }

}
