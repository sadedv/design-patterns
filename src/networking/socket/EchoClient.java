package networking.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {

    public static void main(String[] args) throws IOException {

        String host = args[0];
        System.out.println("Host: " + host);

        // 1. Socket
        Socket echoSocket = null;

        // 2. Writer
        PrintWriter out = null;

        // 3. Reader
        BufferedReader in = null;

        try {

            // Create new socket (Server should accept the connection)
            echoSocket = new Socket(host, 7);

            // Get output stream from socket
            out = new PrintWriter(echoSocket.getOutputStream(), true);

            // Get input stream from socket
            in = new BufferedReader(new InputStreamReader(
                    echoSocket.getInputStream()));

        } catch (UnknownHostException e) {
            System.err.println("Unknown host!");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                    + "the connection to: localhost!");
            System.exit(1);
        }

        // Reader for standard input (user input)
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(
                System.in));

        String fromServer;
        String fromClient;

        // Read from and write to socket
        while ((fromServer = in.readLine()) != null) {

            // Print out the string from socket 
            System.out.println("Server: " + fromServer);

            // Read user input
            fromClient = stdIn.readLine();
            if (fromClient != null) {
                out.println(fromClient);
            }
            
            // Break the loop if user input equals 'exit'
            if (fromClient.equals("exit")) {
                break;
            }

        }

        // Close writer, reader and socket
        out.close();
        in.close();
        stdIn.close();
        echoSocket.close();
    }

}
