package ua.kiev.minaeva.ocp.collections;

import java.util.HashMap;
import java.util.Map;

public class EqualsPresent {

    static class Key {

        Integer id;

        public Key(Integer id) {
            this.id = id;
        }

        @Override
        public int hashCode() {
            return id.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            boolean result = false;

            if (o instanceof Key) {
                result = (((Key) o).id).equals(this.id);
            }

            return result;
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
