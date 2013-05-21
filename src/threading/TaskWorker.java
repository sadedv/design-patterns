package threading;

import java.awt.HeadlessException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

public class TaskWorker extends SwingWorker<String, String> {

    @Override
    protected String doInBackground() throws Exception {

        TimeUnit.MILLISECONDS.sleep(1000);
        
        System.out.println("is event dispatch thread: " + javax.swing.SwingUtilities.isEventDispatchThread());

        return "Tomas";
    }

    @Override
    protected void done() {

        try {
            JOptionPane.showMessageDialog(null, get());
        } catch (HeadlessException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        super.done();
    }

}
