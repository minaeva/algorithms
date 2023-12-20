package ua.kiev.minaeva.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiClientPostGetServer {

    public static void main(String[] args) {
        int port = 8060;

        for (int i = 0; i < 10; i++) {
            GetClient client = new GetClient();
            new Thread(client).start();
        }

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            System.out.println("Error handling server " + e.getMessage());
        }
    }
}
