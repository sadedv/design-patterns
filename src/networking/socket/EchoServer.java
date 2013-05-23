package networking.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServer {

    public static void main(String[] args) throws IOException {

        boolean listening = true;

        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(7);
        } catch (IOException e) {
            System.out.println("Could not listen on port: 7");
            System.exit(-1);
        }

        System.out.println("Server Application");
        System.out.println("Waiting for clients ...");

        ExecutorService executor = Executors.newCachedThreadPool();

        while (listening) {
            executor.execute(new EchoServerThread(serverSocket.accept()));
            System.out.println("Waiting for clients ...");
        }

        executor.shutdown();
        serverSocket.close();

    }

}
