package ua.kiev.minaeva;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class BinaryTree {

    Node root;

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, int data) {
        if (current == null) {
            return new Node(data);
        } else {
            if (data < current.data) {
                current.left = addRecursive(current.left, data);
            } else if (data > current.data) {
                current.right = addRecursive(current.right, data);
            } else {
                return current;
            }
            return current;
        }
    }

    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    private boolean containsNodeRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.data) {
            return true;
        }
        return value < current.data
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.data) {
            //node is a leaf
            if (current.left == null && current.right == null) {
                return null;
            }
            //one child only
            if (current.right == null) {
                return current.left;
            }
            if (current.left == null) {
                return current.right;
            }
            // Node to delete found
            Node smallestValueNode = findSmallestValueNode(current.right);
            smallestValueNode.left = current.left;
            if (current.right != smallestValueNode) {
                smallestValueNode.right = current.right;
            }
            return smallestValueNode;
        }
        if (value < current.data) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        current.right = deleteRecursive(current.right, value);
        return current;
    }

    private Node findSmallestValueNode(Node root) {
        return root.left == null ? root : findSmallestValueNode(root.left);
    }

    public void levelOrder() {
        Queue<Node> q = new LinkedList<>();
        q.add(this.root);

        while (!q.isEmpty()) {
            Node temp = q.poll();
            System.out.print(temp.data + " ");
            if (temp.left != null)
                q.offer(temp.left);
            if (temp.right != null)
                q.offer(temp.right);
        }
     }

    public void printTree(PrintStream os) {
        StringBuilder sb = new StringBuilder();
        traversePreOrder(sb, "", "", this.root);
        os.print(sb);
    }

    private void traversePreOrder(StringBuilder sb, String padding, String pointer, Node node) {
        if (node != null) {
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.data);
            sb.append("\n");

            String paddingForBoth = padding + "│  ";
            String pointerForRight = "└──";
            String pointerForLeft = (node.right != null) ? "├──" : "└──";

            traversePreOrder(sb, paddingForBoth, pointerForLeft, node.left);
            traversePreOrder(sb, paddingForBoth, pointerForRight, node.right);
        }
    }

}