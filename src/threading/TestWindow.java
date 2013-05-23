package threading;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;

public class TestWindow extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;

    TaskWorker taskWorker;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TestWindow frame = new TestWindow();
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
    public TestWindow() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnNewButton = new JButton("New button");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnNewButton.setBounds(10, 11, 89, 23);
        contentPane.add(btnNewButton);

        JButton button = new JButton("New button");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                SwingWorker<String, String> worker = new SwingWorker<String, String>() {

                    @Override
                    protected String doInBackground() throws Exception {

                        for (int i = 0; i < 5; i++) {

                            System.out
                                    .println("working... is event dispatch thread? "
                                            + javax.swing.SwingUtilities
                                                    .isEventDispatchThread());
                            TimeUnit.MILLISECONDS.sleep(500);

                        }

                        return null;
                    }

                };

                worker.execute();

            }
        });
        button.setBounds(10, 45, 89, 23);
        contentPane.add(button);

        taskWorker = new TaskWorker();
    }
}
