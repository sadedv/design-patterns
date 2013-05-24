package networking.multicast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class Chat {

    public static final int PORT = 4445;
    public static final String HOST = "235.0.0.1";

    public static void main(String[] args) throws IOException,
            InterruptedException {

        // Setup socket and join to the group
        InetAddress group = InetAddress.getByName(HOST);
        MulticastSocket socket = new MulticastSocket(PORT);
        socket.joinGroup(group);

        // Execute chat listener in separated thread
        ExecutorService exec = Executors
                .newSingleThreadScheduledExecutor(new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread t = new Thread(r);
                        t.setDaemon(true);
                        return t;
                    }
                });
        exec.execute(new ChatListener());
        exec.shutdown();

        System.out.println("Enter message: ");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = new String();

        while ((line = in.readLine()) != null) {
            if (line.equals("exit")) {
                break;
            }
            DatagramPacket packet = new DatagramPacket(line.getBytes(),
                    line.length(), group, PORT);
            socket.send(packet);
        }
        socket.leaveGroup(group);

        TimeUnit.SECONDS.sleep(5);

    }

}

class ChatListener implements Runnable {

    @Override
    public void run() {
        try {
            InetAddress group = InetAddress.getByName(Chat.HOST);
            MulticastSocket socket = new MulticastSocket(Chat.PORT);
            socket.joinGroup(group);
            while (true) {
                byte[] buffer = new byte[256];
                DatagramPacket packet = new DatagramPacket(buffer,
                        buffer.length);
                socket.receive(packet);
                System.out.println("Received: "
                        + new String(packet.getData(), 0, packet.getLength()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
