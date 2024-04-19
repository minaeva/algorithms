package ua.kiev.minaeva.ocp.enums;

import java.util.Map;
import java.util.TreeMap;

enum TrafficLight {
    RED, YELLOW, GREEN
}

public class EnumValuesTest {

    public static void main(String[] args) {
        Map<TrafficLight, String> map = new TreeMap<>();
        map.put(TrafficLight.GREEN, "GO");
        map.put(TrafficLight.RED, "STOP");
        map.put(TrafficLight.YELLOW, "READY TO STOP");

        for (String msg : map.values()) {
            System.out.println(msg); // STOP => READY TO STOP => GO
        }
    }
}
