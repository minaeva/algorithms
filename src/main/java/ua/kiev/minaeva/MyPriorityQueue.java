package ua.kiev.minaeva;

import java.util.ArrayList;
import java.util.List;

public class MyPriorityQueue<T extends Comparable<T>> {

    List<T> heap;

    public MyPriorityQueue() {
        this.heap = new ArrayList<>();
    }

    public void add(T element) {
        heap.add(element);
        bubbleUp(heap.size() - 1);
    }

    public void remove(T element) {
        int index = heap.indexOf(element);
        if (index == -1) {
            throw new IllegalArgumentException();
        }
        int lastIndex = heap.size() - 1;
        T lastElemment = heap.get(lastIndex);
        heap.set(index, lastElemment);
        heap.remove(lastIndex);
        bubbleDown(index);
    }

    private void bubbleUp(int index) {
        if (index > 0) {
            int parentIndex = (index - 1) / 2;
            T current = heap.get(index);
            T parent = heap.get(parentIndex);
            if (current.compareTo(parent) < 0) {
                heap.set(parentIndex, current);
                heap.set(index, parent);
                bubbleUp(parentIndex);
            }
        }
    }

    private void bubbleDown(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int smallestChildIndex = index;

        if (leftChildIndex < heap.size() && heap.get(leftChildIndex).compareTo(heap.get(smallestChildIndex)) < 0) {
            smallestChildIndex = leftChildIndex;
        }

        if (rightChildIndex < heap.size() && heap.get(rightChildIndex).compareTo(heap.get(smallestChildIndex)) < 0) {
            smallestChildIndex = rightChildIndex;
        }

        if (smallestChildIndex != index) {
            T temp = heap.get(index);
            heap.set(index, heap.get(smallestChildIndex));
            heap.set(smallestChildIndex, temp);
            bubbleDown(smallestChildIndex);
        }
    }

    public void print() {
        heap.forEach(System.out::println);
        System.out.println("---");
    }

    public List<T> getHeapSnapshot() {
        return new ArrayList<>(heap);
    }
}
