package networking.multicast;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChatWindow extends JFrame {

    private static final long serialVersionUID = 1L;

    // Components
    Container pane;
    JPanel mainPanel;
    JPanel leftPanel;
    JPanel rightPanel;

    public ChatWindow() {

        // Setup
        setSize(new Dimension(800, 600));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Simple Chat Application");

        // Initialize components
        initComponents();

        // Layout components
        layoutComponents();

    }

    private void initComponents() {

        pane = getContentPane();
        pane.setLayout(new FlowLayout());

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBackground(new Color(180, 180, 180));
        pane.add(mainPanel);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        leftPanel = new JPanel();
        leftPanel.setBackground(new Color(200, 200, 200));
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 6;
        mainPanel.add(leftPanel, c);

        rightPanel = new JPanel();
        rightPanel.setBackground(new Color(190, 190, 190));
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 2;
        mainPanel.add(rightPanel, c);
    }

    private void layoutComponents() {

        mainPanel.setPreferredSize(new Dimension(pane.getWidth() - 10, pane
                .getHeight() - 10));

    }

}
