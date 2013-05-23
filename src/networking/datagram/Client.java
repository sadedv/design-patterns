package networking.datagram;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {

    public static void main(String[] args) throws IOException {
        
        if (args.length != 1) {
            System.out.println("Usage: java Client <hostname>");
            return;
        }
        
        // Create a datagram socket
        DatagramSocket socket = new DatagramSocket();
        
        // Send request
        byte[] buffer = new byte[256];
        buffer = "This is my request!".getBytes();
        InetAddress address = InetAddress.getByName(args[0]);
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 4445);
        socket.send(packet); // send packet
        
        // Get response
        packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet); // waiting for packet
        
        // Display response
        String received = new String(packet.getData(), 0, packet.getLength());
        
        System.out.println("From server: " + received);
        
        socket.close();
    }
    
}
