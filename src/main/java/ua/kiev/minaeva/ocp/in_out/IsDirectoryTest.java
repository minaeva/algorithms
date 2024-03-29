package ua.kiev.minaeva.ocp.in_out;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IsDirectoryTest {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/Users/svetaminaeva/Desktop");
        System.out.println(Files.isDirectory(path));
        System.out.println(path.toFile().isDirectory());
        System.out.println(Files.getAttribute(path, "isDirectory"));
//        System.out.println(new File(path).isDirectory()); // NO
//        System.out.println(File.isDirectory.(path)); // NO
    }
}
