package ua.kiev.minaeva.ocp.in_out;

import java.io.*;

public class FileNotFound {
    public static void main(String[] args) {
        try (FileReader fr = new FileReader("/Users/svetaminaeva/Desktop/low symbols.png")) {
        } catch (FileNotFoundException e) { // this one only doesn't work, IOException is needed
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
