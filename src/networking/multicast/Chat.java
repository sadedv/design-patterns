package networking.multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import javax.swing.JTextArea;

public class Chat {

    private static int port;
    private static String host;
    
    private String name;

    private MulticastSocket socket;
    private InetAddress group;

    public static int getPort() {
        return port;
    }

    public static String getHost() {
        return host;
    }

    public Chat(JTextArea messages, int port, String host, String name) {
        Chat.port = port;
        Chat.host = host;
        
        this.name = name;

        try {
            socket = new MulticastSocket(port);
            group = InetAddress.getByName(host);
            socket.joinGroup(group);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ExecutorService exec = Executors
                .newSingleThreadScheduledExecutor(new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread t = new Thread(r);
                        t.setDaemon(true);
                        return t;
                    }
                });
        exec.execute(new ChatListener(messages));
        exec.shutdown();
    }

    public void disconnect() {
        try {
            socket.leaveGroup(group);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(String message) {

        message  = name + " > " + message;  
        
        DatagramPacket packet = new DatagramPacket(message.getBytes(),
                message.length(), group, port);
        try {
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

class ChatListener implements Runnable {

    private JTextArea label;

    public ChatListener(JTextArea messages) {
        this.label = messages;
    }

    @Override
    public void run() {
        try {
            MulticastSocket socket = new MulticastSocket(Chat.getPort());
            InetAddress group = InetAddress.getByName(Chat.getHost());
            socket.joinGroup(group);
            while (true) {
                byte[] buffer = new byte[256];
                DatagramPacket packet = new DatagramPacket(buffer,
                        buffer.length);
                socket.receive(packet);
                String received = new String(packet.getData(), 0,
                        packet.getLength());
                String text = label.getText() + "\n" + received;
                label.setText(text);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
