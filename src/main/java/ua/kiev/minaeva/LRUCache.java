package ua.kiev.minaeva;

import java.util.*;

public class LRUCache {

    class LRUNode {
        int key;
        int value;
        LRUNode prev;
        LRUNode next;

        public LRUNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;

    private final Map<Integer, LRUNode> hashMap;
    // borders of the queue
    // first value is actually head.next, last value - tail.previous
    private final LRUNode head;
    private final LRUNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        hashMap = new HashMap<>();

        head = new LRUNode(0, 0);
        tail = new LRUNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!hashMap.containsKey(key)) {
            return -1;
        }
        LRUNode node = hashMap.get(key);
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        LRUNode node = hashMap.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
        } else {
            LRUNode newNode = new LRUNode(key, value);
            if (hashMap.size() == capacity) {
                LRUNode nodeToRemove = tail.prev;
                nodeToRemove.prev.next = tail;
                tail.prev = nodeToRemove.prev;
                hashMap.remove(nodeToRemove.key);
            }
            hashMap.put(key, newNode);
            addToHead(newNode);
        }
    }

    public void print() {
        LRUNode current = head.next;
        while (current != tail) {
            System.out.println(current.key + " " + current.value);
            current = current.next;
        }
        System.out.println("===========");
    }

    private void moveToHead(LRUNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(LRUNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(LRUNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
}
