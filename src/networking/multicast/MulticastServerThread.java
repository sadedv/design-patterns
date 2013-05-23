package networking.multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastServerThread extends Thread {

    private MulticastSocket socket;

    public MulticastServerThread() throws IOException {
        socket = new MulticastSocket(4446);
    }

    @Override
    public void run() {
        while (true) {
            try {
                byte[] buffer = new byte[256];
                buffer = "Hello from server!".getBytes();

                InetAddress group = InetAddress.getByName("235.0.0.1");
                DatagramPacket packet = new DatagramPacket(buffer,
                        buffer.length, group, 4446);
                socket.send(packet);

                sleep(1000);

            } catch (IOException e) {
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
