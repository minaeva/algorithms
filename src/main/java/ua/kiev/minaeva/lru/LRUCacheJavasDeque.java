package ua.kiev.minaeva.lru;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class LRUCacheJavasDeque {

    private final int capacity;
    private final Map<Integer, Integer> map;
    private Deque<Integer> deque;

    public LRUCacheJavasDeque(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
    }

    public void put(int key, int value) {
        //if map contains key
        if (map.containsKey(key)) {
            map.put(key, value);
            deque.remove(key);
            deque.addFirst(key);
            return;
        }
        //if map does not contain key
        //if we have reached the capacity
        if (map.size() == capacity) {
            int oldest = deque.removeLast();
            map.remove(oldest);
        }
        //if map does not contain key
        // and there's still room for new elements
        map.put(key, value);
        deque.addFirst(key);
    }

    public int get(int key) {
        Integer value = map.get(key);
        if (value == null) {
            return -1;
        }
        deque.remove(key);
        deque.addFirst(key);
        return value;
    }
}
