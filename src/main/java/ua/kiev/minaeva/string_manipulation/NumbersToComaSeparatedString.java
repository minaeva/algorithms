package ua.kiev.minaeva.string_manipulation;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Arrays;
import java.util.stream.Collectors;

public class NumbersToComaSeparatedString {

    static String input = """
            4
            5
            7
            10
            30
            50
            100
            200
            500
            1000
              """;

    public String transform() {
        return Arrays.stream(input.split("\n"))
                .map(String::trim)
                .collect(Collectors.joining(","));
    }

    public void copyToClipBoard(String string) {
        // Create a StringSelection object with the text to copy
        StringSelection selection = new StringSelection(string);

        // Get the system clipboard
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

        // Set the contents of the clipboard to the StringSelection object
        clipboard.setContents(selection, null);
    }
    @Test
    void runTransform() {
        String result = transform();
        copyToClipBoard(result);
        System.out.println(result);
    }
}
