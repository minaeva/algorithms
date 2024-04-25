package ua.kiev.minaeva.string_manipulation;

import java.util.ArrayList;
import java.util.List;

public class ParsePayLines {

    static String fromExcel = """
            0	1	2	3	4
            5	6	7	8	9
            10	11	12	13	14
            0	6	12	8	4
            10	6	2	8	14
            5	1	2	3	9
            5	11	12	13	9
            0	1	7	13	14
            10	11	7	3	4
            5	11	7	3	9
            5	1	7	13	9
            0	6	7	8	4
            10	6	7	8	14
            0	6	2	3	9
            10	6	12	8	14
            5	6	2	8	9
            5	6	12	8	9
            0	1	12	3	4
            10	11	2	13	14
            0	11	12	13	14
            """;

    public static void main(String[] args) {
        String colon = fromExcel.replaceAll("\t", ":");
        String[] lines = colon.split("\n");
        List<String> result = new ArrayList<>();
        int i = 0;
        for (String line: lines) {
            result.add("<item values=\"" + line + "\"/>");
            System.out.println(result.get(i++));
        }
    }

}
