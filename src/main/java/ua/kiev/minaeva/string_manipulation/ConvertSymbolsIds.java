package ua.kiev.minaeva.string_manipulation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConvertSymbolsIds {

    int width = 5;
    String symbolsScreen = """
            ["H3","M1","M3","M1","M2"],
            ["H3","WD","M3","WD","M2"],
            ["H2","L2","L2","M1","M3"]
            """;

    String responseScreen =
            "3,13,6,6,12," +
                    "10,3,6,11,11," +
                    "9,6,12,11,9"
            ;

    Map<String, String> symbol_id = new HashMap<>();

    {
        symbol_id.put("WD", "2");
        symbol_id.put("H1", "3");
        symbol_id.put("H2", "4");
        symbol_id.put("H3", "5");
        symbol_id.put("M1", "6");
        symbol_id.put("M2", "7");
        symbol_id.put("M3", "8");
        symbol_id.put("L1", "9");
        symbol_id.put("L2", "10");
        symbol_id.put("L3", "11");
        symbol_id.put("L4", "12");
        symbol_id.put("SR", "13");
        symbol_id.put("SB", "14");
        symbol_id.put("SG", "15");
    }

    public void symbolsToIds() {
        List<String> symbols = stringToListOfElements(symbolsScreen);
        List<String> ids = symbols.stream().map(symbol_id::get).toList();

        List<String> responseIds = stringToListOfElements(responseScreen);

        System.out.println("randomLog Ids");
        printMatrix(ids);
        System.out.println("response Ids");
        printMatrix(responseIds);

        System.out.println(ids.equals(responseIds));
    }

    public void idsToSymbols() {
        List<String> responseIds = stringToListOfElements(responseScreen);
        Map<String, String> id_symbol = symbol_id.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getValue,
                        Map.Entry::getKey
                ));
        List<String> responseSymbols = responseIds.stream().map(id_symbol::get).toList();

        System.out.println("response symbols");
        printMatrix(responseSymbols);
    }

    private  List<String> stringToListOfElements(String string) {
        String[] randomLogSymbols = string.replaceAll("\n", "").split(",");

        List<String> result = new ArrayList<>();
        for (String symbol : randomLogSymbols) {
            result.add(symbol
                    .replaceAll("\\]", "")
                    .replaceAll("\\[", " ")
                    .replaceAll("\"", " ")
                    .trim());
        }
        return result;
    }

    private  void printMatrix(List<String> ids) {
        int size = ids.size();
        for (int j = 0; j < size / width; j++) {
            for (int i = j; i < j + width; i++) {
                System.out.print(ids.get(i) + " ");
            }
            System.out.print("\n");
        }
    }


    @Test
    void testSymbolsToIds() {
        // paste random log matrix (symbols) and response matrix (ids)
        symbolsToIds();
    }

    @Test
    void testIdsToSymbols() {
        // paste response matrix (ids)
        idsToSymbols();
    }
}
