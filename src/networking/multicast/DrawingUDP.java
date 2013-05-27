package networking.multicast;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import javax.swing.JPanel;

public class DrawingUDP {
    private static int port;
    private static String host;

    private MulticastSocket socket;
    private InetAddress group;

    public static int getPort() {
        return port;
    }

    public static String getHost() {
        return host;
    }

    public DrawingUDP(JPanel canvas, int port, String host) {
        DrawingUDP.port = port;
        DrawingUDP.host = host;

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
        exec.execute(new DrawListener(canvas));
        exec.shutdown();
    }

    public void disconnect() {
        try {
            socket.leaveGroup(group);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(MouseEvent event) {

        String coords = event.getX() + ";" + event.getY();

        DatagramPacket packet = new DatagramPacket(coords.getBytes(),
                coords.length(), group, port);
        
        try {
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

class DrawListener implements Runnable {

    private JPanel canvas;

    public DrawListener(JPanel canvas) {
        this.canvas = canvas;
    }

    @Override
    public void run() {
        try {
            MulticastSocket socket = new MulticastSocket(DrawingUDP.getPort());
            InetAddress group = InetAddress.getByName(DrawingUDP.getHost());
            socket.joinGroup(group);
            
            while (true) {
                byte[] buffer = new byte[256];
                DatagramPacket packet = new DatagramPacket(buffer,
                        buffer.length);
                socket.receive(packet);
                String received = new String(packet.getData(), 0,
                        packet.getLength());

                String[] arr = received.split(";");
                int x = Integer.parseInt(arr[0]);
                int y = Integer.parseInt(arr[1]);
                canvas.getGraphics().fillArc(x, y, 5, 5, 0, 360);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
