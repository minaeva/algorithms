package ua.kiev.minaeva;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueDeque {

    int capacity = 3;
    //Allows null elements
    Queue<Integer> queueLinkedList = new LinkedList<>();

    //elements of the priority queue are ordered according to their natural ordering,
    // or by a Comparator provided at queue construction time.
    //Does not permit null elements.
    Queue<Integer> queuePriorityQueue = new PriorityQueue<>(capacity);

    //Likely faster than LinkedList when used as a queue.
    //No capacity restrictions; grows as necessary to support usage.
    //Does not permit null elements.
    Queue<Integer> queueArrayDeque = new ArrayDeque<>(capacity);

    Deque<Integer> dequeArrayDeque = new ArrayDeque<>();
    Deque<Integer> dequeLinkedList = new LinkedList<>();
    Deque<Integer> dequeLinkedBlockingDeque = new LinkedBlockingDeque<>();
    Deque<Integer> dequeConcurrentLinkedDeque = new ConcurrentLinkedDeque<>();


    // add only to the tail, get from the head
// Inserts the specified element into the queue
// add (exception) - offer (false)
// Retrieves and removes the head of the queue
// remove (exception) - poll (null)
// Retrieves, but does not remove, the head of the queue
// element (exception) - peak (null)
    public void queueLinkedListOperations() {
        queueLinkedList.add(5);
        queueLinkedList.add(3);
        queueLinkedList.add(8);

        queueLinkedList.forEach(System.out::println);
        System.out.println("The first one: " + queueLinkedList.poll());
        System.out.println("The second one: " + queueLinkedList.poll());
        System.out.println("The last one: " + queueLinkedList.poll());
    }

    public void queuePriorityQueueOperations() {
        queuePriorityQueue.add(5);
        queuePriorityQueue.add(3);
        queuePriorityQueue.add(8);
        queuePriorityQueue.forEach(System.out::println);
    }

    public void queueArrayDequeOperations() {
        queueArrayDeque.add(5);
        queueArrayDeque.add(3);
        queueArrayDeque.add(8);

        queueArrayDeque.forEach(System.out::println);
    }

//
//    Summary of Deque methods
//    Insert	addFirst(e)	offerFirst(e)	addLast(e)	offerLast(e)
//    Remove	removeFirst()	pollFirst()	removeLast()	pollLast()
//    Examine	getFirst()	peekFirst()	getLast()	peekLast()


    @Test
    void print(){
        System.out.println("LinkedList");
        queueLinkedListOperations();
        System.out.println("Priority Queue");
        queuePriorityQueueOperations();
        System.out.println("Array Deque");
        queueArrayDequeOperations();
    }
}
