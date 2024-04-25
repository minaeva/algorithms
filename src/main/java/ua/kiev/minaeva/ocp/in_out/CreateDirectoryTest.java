package ua.kiev.minaeva.ocp.in_out;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreateDirectoryTest {

    public static void main(String[] args) throws IOException {
        // /A/B folders are absent
        Path path = Paths.get("/Users/svetaminaeva/Desktop/files/A/B"); //NoSuchFileException
        Files.createDirectory(path);
    }
}
