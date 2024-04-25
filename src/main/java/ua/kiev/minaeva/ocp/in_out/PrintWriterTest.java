package ua.kiev.minaeva.ocp.in_out;

import java.io.PrintWriter;

public class PrintWriterTest {

    public static void main(String[] args) {
        try(PrintWriter writer = new PrintWriter(System.out)) {
            writer.println("Hello");
        } catch(Exception ex) {
//            writer.close(); // non reachable
        }
    }
}
