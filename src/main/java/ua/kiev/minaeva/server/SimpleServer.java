package ua.kiev.minaeva.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

    public static void main(String[] args) {
        int port = 8070;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("server started");

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                    String line;
                    StringBuilder request = new StringBuilder();

                    while ((line = in.readLine()) != null && !line.isEmpty()) {
                        request.append(line).append("\n");
                    }

                    System.out.println(request);

                    out.println("HTTP/1.1 200 OK");
                    out.println("Content-Type: text/plain");
                    out.println();
                    out.println("This is a simple server response");
                    out.flush();
                } catch (IOException exception) {
                    System.out.println("Error handling client: " + exception.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error handling server " + e.getMessage());
        }
    }

}
