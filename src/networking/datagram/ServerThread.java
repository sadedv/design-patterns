package networking.datagram;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ServerThread extends Thread {

    private DatagramSocket socket = null;

    public ServerThread() throws SocketException {
        super("ServerThread");

        // Create new datagram socket in constructor
        socket = new DatagramSocket(4445);
    }

    @Override
    public void run() {

        while (true) {
            try {

                // Blank buffer
                byte[] buffer = new byte[256];

                // Receive requests
                DatagramPacket packet = new DatagramPacket(buffer,
                        buffer.length);
                socket.receive(packet); // waiting for packet

                System.out.println("From client: "
                        + new String(packet.getData(), 0, packet.getLength()));

                buffer = "Hello Tomas!".getBytes();

                // Send packet
                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                packet = new DatagramPacket(buffer, buffer.length, address,
                        port);
                socket.send(packet); // send packet

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
