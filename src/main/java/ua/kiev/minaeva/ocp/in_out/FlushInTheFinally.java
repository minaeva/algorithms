package ua.kiev.minaeva.ocp.in_out;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FlushInTheFinally {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/svetaminaeva/Desktop/low symbols.png"));
//        try (BufferedWriter writer = bw) { //Line 10
//        try (BufferedWriter writer = new BufferedWriter(bw)) { //Line 11
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/svetaminaeva/Desktop/low symbols.png"))) { //Line 8

        } finally {
            bw.flush(); // with line 10 or line 11 -> IOException: Stream closed
        }
    }
}
