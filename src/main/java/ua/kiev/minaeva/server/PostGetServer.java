package ua.kiev.minaeva.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class PostGetServer {

    public static void main(String[] args) {
        int port = 8080;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("server started");

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                    String line = in.readLine();
                    if (line == null) continue;

                    if (line.startsWith("POST")) {
                        handlePostRequest(in, out);
                    } else {
                        handleGetRequest(out);
                    }

                } catch (IOException exception) {
                    System.out.println("Error handling client: " + exception.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error handling server " + e.getMessage());
        }
    }

    private static void handlePostRequest(BufferedReader in, PrintWriter out) throws IOException {

        StringBuilder payload = new StringBuilder();
        String line;

        int contentLength = 0;
        while ((line = in.readLine()) != null && !line.isEmpty()) {
            if (line.startsWith("Content-Length: ")) {
                contentLength = Integer.parseInt(line.substring("Content-Length: ".length()));
            }
        }

        if (contentLength > 0) {
            char[] buffer = new char[contentLength];
            in.read(buffer, 0, contentLength);
            payload.append(new String(buffer));
        }

        out.println("HTTP/1.1 200 OK");
        out.println("Content-Type: text/plain");
        out.println(); // End of headers
        out.println("Received POST request with data: " + payload);
        out.flush();

    }

    private static void handleGetRequest(PrintWriter out) {
        out.println("HTTP/1.1 200 OK");
        out.println("Content-Type: text/plain");
        out.println(); // End of headers
        out.println("This is a response to a non-POST request.");
        out.flush();
    }


}
