package classes;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class AppWindow extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            EventQueue.invokeAndWait(new Runnable() {
                public void run() {
                    try {
                        AppWindow frame = new AppWindow();
                        frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Main method");
    }

    /**
     * Create the frame.
     */
    public AppWindow() {
        setTitle("Thread Test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 329, 227);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel1 = new JPanel();
        panel1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel1.setBounds(10, 11, 293, 78);
        contentPane.add(panel1);
        panel1.setLayout(null);

        JButton btnStartThread1 = new JButton("Start Thread");
        btnStartThread1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(javax.swing.SwingUtilities
                        .isEventDispatchThread());
            }
        });
        btnStartThread1.setBounds(10, 11, 130, 23);
        panel1.add(btnStartThread1);

        JButton btnStopThread1 = new JButton("Stop Thread");
        btnStopThread1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnStopThread1.setBounds(150, 11, 130, 23);
        panel1.add(btnStopThread1);

        JLabel label1 = new JLabel("Thread is stopped.");
        label1.setBounds(10, 45, 130, 14);
        panel1.add(label1);

        JPanel panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel2.setBounds(10, 100, 293, 78);
        contentPane.add(panel2);

        JButton btnStartThread2 = new JButton("Start Thread");
        btnStartThread2.setBounds(10, 11, 130, 23);
        panel2.add(btnStartThread2);

        JButton btnStopThread2 = new JButton("Stop Thread");
        btnStopThread2.setBounds(150, 11, 130, 23);
        panel2.add(btnStopThread2);

        JLabel label2 = new JLabel("Thread is stopped.");
        label2.setBounds(10, 45, 130, 14);
        panel2.add(label2);

    }
}
