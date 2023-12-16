package ua.kiev.minaeva;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinaryTreeTest {

    @Test
    public void whenAddingElements_thenTreeContainsThem() {
        BinaryTree bt = createBinaryTree();

        assertThat(bt.containsNode(6)).isTrue();
        assertTrue(bt.containsNode(4));
        assertFalse(bt.containsNode(1));
    }

    @Test
    public void whenDeletingLeaf_thenTreeDoesNotContainIt() {
        BinaryTree bt = createBinaryTree();
        assertTrue(bt.containsNode(3));

        bt.delete(3);
        assertFalse(bt.containsNode(3));
    }

    @Test
    public void whenDeletingOneChildNode_thenTreeDoesNotContainIt() {
        BinaryTree bt = createBinaryTree();
        assertTrue(bt.containsNode(8));

        bt.delete(8);
        assertFalse(bt.containsNode(8));
    }

    @Test
    public void whenDeletingTwoChildrenNode_thenTreeDoesNotContainIt() {
        BinaryTree bt = createBinaryTree();
        System.out.println("***** Created tree");
        bt.printTree(System.out);
        assertTrue(bt.containsNode(10));
        assertTrue(bt.containsNode(8));
        assertTrue(bt.containsNode(11));

        bt.delete(10);
        System.out.println("***** After value 10 has been deleted");
        bt.printTree(System.out);
        assertFalse(bt.containsNode(10));
        assertTrue(bt.containsNode(8));
        assertTrue(bt.containsNode(11));
    }

    @Test
    public void levelOrder_should() {
        BinaryTree bt = createBinaryTree();
        bt.levelOrder();
    }

    private BinaryTree createBinaryTree() {
        BinaryTree bt = new BinaryTree();
        bt.add(6);
        bt.add(4);
        bt.add(10);
        bt.add(3);
        bt.add(5);
        bt.add(8);
        bt.add(7);
        bt.add(11);
        return bt;
    }


}
