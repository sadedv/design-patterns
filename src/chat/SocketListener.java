package chat;

import java.io.BufferedReader;
import java.io.IOException;

public class SocketListener implements Runnable {

    private BufferedReader reader;
    private String from;

    public SocketListener(BufferedReader reader, String from) {
        this.reader = reader;
        this.from = from;
    }

    @Override
    public void run() {

        String message;

        try {
            while ((message = reader.readLine()) != null) {
                System.out.println(from + ": " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
