package ua.kiev.minaeva.ocp.collections;

import java.util.HashMap;
import java.util.Map;

public class EqualsAbsent {

    static class Key {

        Integer id;

        public Key(Integer id) {
            this.id = id;
        }

        @Override
        public int hashCode() {
            return id.hashCode();
        }
    }

    public static void main(String[] args) {
        Map<Key, String> map = new HashMap<>();

        while (true) {
            for (int i = 0; i < 10000; i++) {
                if (!map.containsKey(new Key(i))) {
                    map.put(new Key(i), "Number : " + i);
                }
                
            }
        }
    }
}
