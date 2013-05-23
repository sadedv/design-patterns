package networking.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoServerThread implements Runnable {

    private static int id;
    private int thisId;
    private Socket clientSocket;

    public EchoServerThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
        this.thisId = id++;
        System.out.println("Created new communication with ID: " + id);
    }

    @Override
    public void run() {

        PrintWriter out = null;
        BufferedReader in = null;

        try {

            out = new PrintWriter(clientSocket.getOutputStream(), true);

            in = new BufferedReader(new InputStreamReader(
                    clientSocket.getInputStream()));

            // Write to the socket
            out.println("Hello, you are successfully connected");

            String fromClient;

            while ((fromClient = in.readLine()) != null) {

                // Print out the string from socket
                System.out.println("Client_" + thisId + ": " + fromClient);

                // Break the loop if user input equals 'exit'
                if (fromClient.equals("exit")) {
                    break;
                }

                out.println("OK");

            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            out.close();

            try {

                in.close();
                clientSocket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

}
