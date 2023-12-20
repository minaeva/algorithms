package ua.kiev.minaeva.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GetClient implements Runnable {

    @Override
    public void run() {

        String hostname = "localhost";
        int port = 8060;

        try (Socket socket = new Socket(hostname, port)) {
            System.out.println("New client started ");
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println("GET / HTTP/1.1");
            out.println("Host: " + hostname);
            out.println("Connection: Close");
            out.println();

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
        } catch (IOException e) {
            System.out.println("Error occurred when connecting to server: " + e.getMessage());
        }
    }
}
