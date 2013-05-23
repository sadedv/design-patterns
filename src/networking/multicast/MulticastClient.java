package networking.multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastClient {

    public static void main(String[] args) throws IOException {

        MulticastSocket socket = new MulticastSocket(4446);
        InetAddress group = InetAddress.getByName("235.0.0.1");
        socket.joinGroup(group);

        DatagramPacket packet;

        for (int i = 0; i < 5; i++) {

            byte[] buffer = new byte[256];
            packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);

            String received = new String(packet.getData(), 0,
                    packet.getLength());
            System.out.println("Received from server: " + received);
        }

        socket.leaveGroup(group);
        socket.close();
    }

}
