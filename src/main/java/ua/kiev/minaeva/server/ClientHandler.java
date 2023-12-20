package ua.kiev.minaeva.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {

    public static final String CONTENT_LENGTH = "Content-Length: ";
    private final Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
            String line = in.readLine();

            if (line != null && line.startsWith("POST")) {
                System.out.println("Handling POST");
                handlePostMethod(in, out);
            } else {
                System.out.println("Handling GET");
                handleGetMethod(out);
            }
        } catch (IOException e) {
            System.out.println("Error handling client " + e.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.out.println("Error closing client socket " + e.getMessage());
            }
        }
    }

    private void handlePostMethod(BufferedReader in, PrintWriter out) throws IOException, InterruptedException {
        StringBuilder payload = new StringBuilder();
        String line;
        int contentLength = 0;
        while ((line = in.readLine()) != null && !line.isEmpty()) {
            if (line.startsWith(CONTENT_LENGTH)) {
                contentLength = Integer.parseInt(line.substring(CONTENT_LENGTH.length()));
            }
        }

        if (contentLength > 0) {
            char[] buffer = new char[contentLength];
            in.read(buffer, 0, contentLength);
            payload.append(new String(buffer));
        }

        Thread.sleep(3000);
        out.println("HTTP/1.1 200 OK");
        out.println("Content-Type: text/plain");
        out.println();
        out.println("Received POST request with data: " + payload);
        out.flush();
    }

    private void handleGetMethod(PrintWriter out) {
        out.println("HTTP/1.1 200 OK");
        out.println("Content-Type: text/plain");
        out.println();
        out.println("This is a response to a GET request.");
        out.flush();
    }

}
