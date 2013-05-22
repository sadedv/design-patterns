package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(7);
        } catch (IOException e) {
            System.out.println("Could not listen on port: 7");
            System.exit(-1);
        }

        Socket clientSocket = null;

        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.out.println("Accept failed: 7");
            System.exit(-1);
        }

        // Write to the output
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(
                clientSocket.getInputStream()));

        out.println("Hello, you are successfully connected");

        // Create separated thread for listening
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(new SocketListener(in, "server"));
        
        // Reader for standard input (user input)
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(
                System.in));

        String fromServer;

        while (true) {

            // Read user input
            fromServer = stdIn.readLine();

            if (fromServer != null) {
                out.println(fromServer);
            }
            
            if (fromServer.equals("break")) {
                break;
            }
            
        }

        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();

    }

}
