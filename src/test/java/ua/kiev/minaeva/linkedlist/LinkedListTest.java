package ua.kiev.minaeva.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    @Test
    public void testInsertNullThrowsException() {
        LinkedList<Object> list = new LinkedList<>();
        assertThrows(IllegalArgumentException.class, () -> {
            list.insertAtBeginning(null); // Assuming this method uses validate()
        });
    }

    @Test
    void addAbcAtBeginning() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.insertAtBeginning("abc");
        linkedList.print();
    }

    @Test
    void add1AtEnd() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.insertAtEnd(1);
        linkedList.print();

    }

    @Test
    void addAaAtBeginning_andBbAtEnd() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.insertAtBeginning("aa");
        linkedList.insertAtEnd("bb");
        linkedList.insertAtEnd("cc");
        linkedList.print();
    }

    @Test
    void addAaBbCcAtEnd() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.insertAtEnd("aa");
        linkedList.insertAtEnd("bb");
        linkedList.insertAtEnd("cc");
        linkedList.print();
    }

    @Test
    void addAaBbCcAtEnd_insert123AfterBb() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.insertAtEnd("aa");
        linkedList.insertAtEnd("bb");
        linkedList.insertAtEnd("cc");
        linkedList.insertAfter("bb", "123");
        linkedList.print();
    }

    @Test
    void addAaBbCcAtEnd_findBB_shouldFindBb() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.insertAtEnd("aa");
        linkedList.insertAtEnd("bb");
        linkedList.insertAtEnd("cc");

        assertEquals("bb", linkedList.findValue("bb"));
        linkedList.print();
    }

    @Test
    void addAaBbCcAtEnd_findBB_shouldNotFindDd() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.insertAtEnd("aa");
        linkedList.insertAtEnd("bb");
        linkedList.insertAtEnd("cc");

        assertNull(linkedList.findValue("dd"));
        linkedList.print();
    }

    @Test
    void addAaBbCcAtEnd_deleteBB_shouldDeleteBb() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.insertAtEnd("aa");
        linkedList.insertAtEnd("bb");
        linkedList.insertAtEnd("cc");
        linkedList.print();

        linkedList.deleteByValue("bb");
        System.out.println("After");
        linkedList.print();
    }

    @Test
    void addAaBbCcAtEnd_deleteAa_shouldDeleteAa() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.insertAtEnd("aa");
        linkedList.insertAtEnd("bb");
        linkedList.insertAtEnd("cc");
        linkedList.print();

        linkedList.deleteByValue("aa");
        System.out.println("After");
        linkedList.print();
    }

    @Test
    void addAaBbCcAtEnd_deleteCc_shouldDeleteCc() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.insertAtEnd("aa");
        linkedList.insertAtEnd("bb");
        linkedList.insertAtEnd("cc");
        linkedList.print();

        linkedList.deleteByValue("cc");
        System.out.println("After");
        linkedList.print();
    }

    @Test
    void addAaBbCcAtEnd_deletedNumber3_shouldDeleteCc() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.insertAtEnd("aa");
        linkedList.insertAtEnd("bb");
        linkedList.insertAtEnd("cc");
        linkedList.print();

        linkedList.deleteByPosition(2);
        System.out.println("After");
        linkedList.print();
    }

    @Test
    void getSize_shouldReturn3() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.insertAtEnd("aa");
        linkedList.insertAtEnd("bb");
        linkedList.insertAtEnd("cc");
        linkedList.print();

        assertEquals(3, linkedList.getSize());
    }

    @Test
    void getSize_shouldReturn0() {
        LinkedList<String> linkedList = new LinkedList<>();
        assertEquals(0, linkedList.getSize());
    }

}
