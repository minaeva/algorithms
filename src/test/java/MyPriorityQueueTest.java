import org.junit.jupiter.api.Test;
import ua.kiev.minaeva.MyPriorityQueue;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MyPriorityQueueTest {

    @Test
    void add_5_3_7() {
        MyPriorityQueue<Integer> queue = new MyPriorityQueue<>();
        queue.add(5);
        queue.add(3);
        queue.add(7);
        queue.print();
        assertArrayEquals(List.of(3, 5, 7).toArray(), queue.getHeapSnapshot().toArray());

    }

    @Test
    void add_3_7_8_2_4_6() {
        MyPriorityQueue<Integer> queue = new MyPriorityQueue<>();
        queue.add(3);
        queue.add(7);
        queue.add(8);
        assertArrayEquals(List.of(3, 7, 8).toArray(), queue.getHeapSnapshot().toArray());
        queue.print();
        queue.add(2);
        queue.print();
        assertArrayEquals(List.of(2, 3, 8, 7).toArray(), queue.getHeapSnapshot().toArray());
        queue.add(4);
        assertArrayEquals(List.of(2, 3, 8, 7, 4).toArray(), queue.getHeapSnapshot().toArray());
        queue.add(6);
        assertArrayEquals(List.of(2, 3, 6, 7, 4, 8).toArray(), queue.getHeapSnapshot().toArray());
    }

    @Test
    void add_15_10_20_17_8() {
        MyPriorityQueue<Integer> queue = new MyPriorityQueue<>();
        queue.add(15);
        queue.add(10);
        queue.add(20);
        assertArrayEquals(List.of(10, 15, 20).toArray(), queue.getHeapSnapshot().toArray());
        queue.add(17);
        assertArrayEquals(List.of(10, 15, 20, 17).toArray(), queue.getHeapSnapshot().toArray());
        queue.add(8);
        assertArrayEquals(List.of(8, 10, 20, 17, 15).toArray(), queue.getHeapSnapshot().toArray());
    }

    @Test
    void add_15_10_20_17_8_9_16_14() {
        MyPriorityQueue<Integer> queue = new MyPriorityQueue<>();
        queue.add(15);
        queue.add(10);
        queue.add(20);
        queue.add(17);
        queue.add(8);
        queue.add(9);
        assertArrayEquals(List.of(8, 10, 9, 17, 15, 20).toArray(), queue.getHeapSnapshot().toArray());
        queue.add(16);
        assertArrayEquals(List.of(8, 10, 9, 17, 15, 20, 16).toArray(), queue.getHeapSnapshot().toArray());
        queue.add(14);
        assertArrayEquals(List.of(8, 10, 9, 14, 15, 20, 16, 17).toArray(), queue.getHeapSnapshot().toArray());

    }


    @Test
    void add_3_7_8_2_4_6_remove4() {
        MyPriorityQueue<Integer> queue = new MyPriorityQueue<>();
        queue.add(3);
        queue.add(7);
        queue.add(8);
        queue.add(2);
        queue.add(4);
        queue.add(6);
        assertArrayEquals(List.of(2, 3, 6, 7, 4, 8).toArray(), queue.getHeapSnapshot().toArray());
        queue.remove(4);
        assertArrayEquals(List.of(2, 3, 6, 7, 8).toArray(), queue.getHeapSnapshot().toArray());
    }

    @Test
    void add_3_7_8_2_4_6_remove3() {
        MyPriorityQueue<Integer> queue = new MyPriorityQueue<>();
        queue.add(3);
        queue.add(7);
        queue.add(8);
        queue.add(2);
        queue.add(4);
        queue.add(6);
        assertArrayEquals(List.of(2, 3, 6, 7, 4, 8).toArray(), queue.getHeapSnapshot().toArray());
        queue.remove(3);
        assertArrayEquals(List.of(2, 4, 6, 7, 8).toArray(), queue.getHeapSnapshot().toArray());
    }

    @Test
    void add_3_7_8_2_4_6_remove8() {
        MyPriorityQueue<Integer> queue = new MyPriorityQueue<>();
        queue.add(3);
        queue.add(7);
        queue.add(8);
        queue.add(2);
        queue.add(4);
        queue.add(6);
        assertArrayEquals(List.of(2, 3, 6, 7, 4, 8).toArray(), queue.getHeapSnapshot().toArray());
        queue.remove(8);
        assertArrayEquals(List.of(2, 3, 6, 7, 4).toArray(), queue.getHeapSnapshot().toArray());
    }
}
