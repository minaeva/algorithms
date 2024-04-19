package ua.kiev.minaeva.ocp.io;

import java.io.PrintWriter;

public class PrintWriterTest {

    public static void main(String[] args) {
        try (PrintWriter writer = new PrintWriter(System.out)) {
            writer.println("Hello");
        } catch (Exception ex) {
//            writer.close(); // writer is unseen in here
        }
    }
}
