package networking.multicast;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class MainWindow extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;
    private JTextField txtInput;
    private JTextArea messages;
    private JPanel drawingPanel;

    private String host;
    private String name;

    private Chat chat;
    private DrawingUDP drawingUDP;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainWindow frame = new MainWindow();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public MainWindow() {

        setTitle("Drawing Riddle Multiplayer");
        setMinimumSize(new Dimension(800, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setFont(new Font("Arial", Font.PLAIN, 12));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        drawingPanel = new JPanel();
        drawingPanel.setBorder(new TitledBorder(null, "Drawing Area",
                TitledBorder.LEADING, TitledBorder.TOP, null, null));

        drawingPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                drawingUDP.send(e);
            }
        });

        JPanel chatPanel = new JPanel();
        chatPanel.setBorder(new TitledBorder(null, "Chat Window",
                TitledBorder.LEADING, TitledBorder.TOP, null, null));

        JPanel menuPanel = new JPanel();
        menuPanel.setFont(new Font("Arial", Font.PLAIN, 12));
        menuPanel.setBorder(new TitledBorder(UIManager
                .getBorder("TitledBorder.border"), "Menu",
                TitledBorder.LEADING, TitledBorder.TOP, null,
                new Color(0, 0, 0)));
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane
                .setHorizontalGroup(gl_contentPane
                        .createParallelGroup(Alignment.LEADING)
                        .addGroup(
                                gl_contentPane
                                        .createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(
                                                gl_contentPane
                                                        .createParallelGroup(
                                                                Alignment.LEADING)
                                                        .addComponent(
                                                                chatPanel,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                754,
                                                                Short.MAX_VALUE)
                                                        .addGroup(
                                                                Alignment.TRAILING,
                                                                gl_contentPane
                                                                        .createSequentialGroup()
                                                                        .addComponent(
                                                                                drawingPanel,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                569,
                                                                                Short.MAX_VALUE)
                                                                        .addPreferredGap(
                                                                                ComponentPlacement.UNRELATED)
                                                                        .addComponent(
                                                                                menuPanel,
                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                175,
                                                                                GroupLayout.PREFERRED_SIZE)))
                                        .addContainerGap()));
        gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(
                Alignment.LEADING).addGroup(
                gl_contentPane
                        .createSequentialGroup()
                        .addContainerGap()
                        .addGroup(
                                gl_contentPane
                                        .createParallelGroup(Alignment.LEADING)
                                        .addComponent(drawingPanel,
                                                GroupLayout.DEFAULT_SIZE, 386,
                                                Short.MAX_VALUE)
                                        .addComponent(menuPanel,
                                                GroupLayout.DEFAULT_SIZE, 386,
                                                Short.MAX_VALUE))
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(chatPanel, GroupLayout.PREFERRED_SIZE,
                                138, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap()));

        messages = new JTextArea("> Welcome to app!");
        messages.setLineWrap(true);
        messages.setEditable(false);
        messages.setFont(new Font("Monospaced", Font.PLAIN, 12));
        messages.setOpaque(true);
        messages.setBackground(Color.WHITE);
        messages.setBorder(new LineBorder(SystemColor.controlShadow));

        JScrollPane scrollPane = new JScrollPane(messages);
        scrollPane.setVisible(true);
        add(scrollPane);

        txtInput = new JTextField();
        txtInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    chat.send(txtInput.getText());
                    txtInput.setText("");
                    System.out.println("Enter pressed!");
                }

            }
        });
        txtInput.setColumns(10);
        GroupLayout gl_chatPanel = new GroupLayout(chatPanel);
        gl_chatPanel
                .setHorizontalGroup(gl_chatPanel
                        .createParallelGroup(Alignment.TRAILING)
                        .addGroup(
                                gl_chatPanel
                                        .createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(
                                                gl_chatPanel
                                                        .createParallelGroup(
                                                                Alignment.TRAILING)
                                                        .addComponent(
                                                                messages,
                                                                Alignment.LEADING,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                722,
                                                                Short.MAX_VALUE)
                                                        .addComponent(
                                                                txtInput,
                                                                Alignment.LEADING,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                722,
                                                                Short.MAX_VALUE))
                                        .addContainerGap()));
        gl_chatPanel.setVerticalGroup(gl_chatPanel.createParallelGroup(
                Alignment.TRAILING).addGroup(
                gl_chatPanel
                        .createSequentialGroup()
                        .addComponent(messages, GroupLayout.PREFERRED_SIZE, 79,
                                GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(txtInput, GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(6, Short.MAX_VALUE)));
        chatPanel.setLayout(gl_chatPanel);

        JButton btnConnect = new JButton("Connect");
        btnConnect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JTextField txtName = new JTextField(15);
                JTextField txtHost = new JTextField(15);

                JPanel panel = new JPanel();
                panel.add(new JLabel("Enter your name:"));
                panel.add(txtName);
                panel.setPreferredSize(new Dimension(300, 100));
                panel.add(new JLabel("Enter host:"));
                panel.add(txtHost);

                int result = JOptionPane.showConfirmDialog(getContentPane(),
                        panel, "Enter connection informations",
                        JOptionPane.OK_CANCEL_OPTION);

                host = txtHost.getText();
                name = txtName.getText();

                if (result == JOptionPane.OK_OPTION) {
                    init();
                }

            }
        });

        JButton btnDisconnect = new JButton("Disconnect");
        btnDisconnect.setEnabled(false);

        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });

        JList playerList = new JList();
        playerList.setFont(new Font("Arial", Font.PLAIN, 12));
        playerList.setBorder(new LineBorder(SystemColor.activeCaptionBorder));

        JLabel lblLoggedUsers = new JLabel("Active players:");
        GroupLayout gl_menuPanel = new GroupLayout(menuPanel);
        gl_menuPanel.setHorizontalGroup(gl_menuPanel.createParallelGroup(
                Alignment.LEADING).addGroup(
                gl_menuPanel
                        .createSequentialGroup()
                        .addContainerGap()
                        .addGroup(
                                gl_menuPanel
                                        .createParallelGroup(Alignment.LEADING)
                                        .addComponent(playerList,
                                                GroupLayout.DEFAULT_SIZE, 143,
                                                Short.MAX_VALUE)
                                        .addComponent(btnConnect,
                                                GroupLayout.DEFAULT_SIZE, 143,
                                                Short.MAX_VALUE)
                                        .addComponent(btnDisconnect,
                                                GroupLayout.DEFAULT_SIZE, 143,
                                                Short.MAX_VALUE)
                                        .addComponent(btnExit,
                                                GroupLayout.DEFAULT_SIZE, 143,
                                                Short.MAX_VALUE)
                                        .addComponent(lblLoggedUsers))
                        .addContainerGap()));
        gl_menuPanel.setVerticalGroup(gl_menuPanel.createParallelGroup(
                Alignment.LEADING).addGroup(
                gl_menuPanel
                        .createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnConnect)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(btnDisconnect)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(btnExit)
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addComponent(lblLoggedUsers)
                        .addGap(1)
                        .addComponent(playerList, GroupLayout.DEFAULT_SIZE,
                                230, Short.MAX_VALUE).addContainerGap()));
        menuPanel.setLayout(gl_menuPanel);
        contentPane.setLayout(gl_contentPane);
        setVisible(true);

    }

    private void init() {

        createChat();

        createDrawingUDP();

    }

    private void createChat() {

        chat = new Chat(messages, 4445, host, name);

    }

    private void createDrawingUDP() {

        drawingUDP = new DrawingUDP(drawingPanel, 4446, host);

    }
}
