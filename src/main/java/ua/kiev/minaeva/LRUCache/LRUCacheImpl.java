package ua.kiev.minaeva.LRUCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheImpl<T> implements LRUCache<T> {

    class Node {
        String key;
        T value;
        Node prev;
        Node next;

        Node(String key) {
            this.key = key;
        }

        Node(String key, T value) {
            this.key = key;
            this.value = value;
        }
    }

    Map<String, Node> map;
    int capacity;
    Node head;
    Node tail;

    public LRUCacheImpl(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        head = new Node("head");
        tail = new Node("tail");
        head.next = tail;
        tail.prev = head;
    }

    @Override
    public T get(String key) {
        Node nodeToMove = map.get(key);
        if (nodeToMove == null) {
            return null;
        }
        removeFromMiddle(nodeToMove);
        addToHead(nodeToMove);
        return nodeToMove.value;
    }

    @Override
    public void set(String key, T value) {
        Node existingNode = map.get(key);
        if (existingNode == null) {
            // need to add new value
            if (map.size() == capacity) {
                removeLast();
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addToHead(newNode);
        } else {
            // need to move from middle to head
            existingNode.value = value;
            addToHead(existingNode);
            removeFromMiddle(existingNode);
        }
    }

    private void addToHead(Node newHead) {
        newHead.next = head.next;
        newHead.prev = head;
        head.next.prev = newHead;
        head.next = newHead;
    }

    private void removeLast() {
        if (capacity == 1) {
            Node nodeToRemove = head.next;
            tail.prev = head;
            head.next = tail;
            map.remove(nodeToRemove.key);
        } else {

            Node tooOld = tail.prev;
            tooOld.prev.next = tail;
            tail.prev = tooOld.prev;
            map.remove(tooOld.key);
        }
    }

    private void removeFromMiddle(Node nodeToRemove) {
        nodeToRemove.next.prev = nodeToRemove.prev;
        nodeToRemove.prev.next = nodeToRemove.next;
    }
}
