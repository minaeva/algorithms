package ua.kiev.minaeva.linkedlist;

public class LinkedList<T> {

    Node<T> head;

    public LinkedList() {
        this.head = null;
    }

    public Node<T> insertAtBeginning(T data) {
        validate(data);
        Node<T> newNode = new Node<>(data);
        newNode.setNext(this.head);
        this.head = newNode;
        return newNode;
    }

    public Node<T> insertAtEnd(T data) {
        validate(data);
        Node<T> newNode = new Node<>(data);
        if (this.head == null) {
            this.head = newNode;
        } else {
            Node<T> oldLast = findLast();
            oldLast.setNext(newNode);
        }
        return newNode;
    }

    public void print() {
        if (this.head == null) {
            System.out.println("Empty");
        } else {
            Node<T> current = this.head;
            while (current != null) {
                System.out.println(current.getData());
                current = current.getNext();
            }
        }

    }

    private void validate(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Nulls are not allowed");
        }
    }

    private Node<T> findLast() {
        Node<T> current = this.head;
        while (current != null && current.getNext() != null) {
            current = current.getNext();
        }
        return current;
    }

    public Node<T> insertAfter(T dataOfPredecessor, T dataToInsert) {
        validate(dataToInsert);
        Node<T> predecessor = findNode(dataOfPredecessor);
        if (predecessor == null) {
            return null;
        }
        Node<T> newNode = new Node<>(dataToInsert);
        Node<T> oldNext = predecessor.getNext();
        predecessor.setNext(newNode);
        newNode.setNext(oldNext);
        return newNode;
    }

    public T findValue(T data) {
        Node<T> foundNode = findNode(data);
        if (foundNode == null) {
            return null;
        }
        return foundNode.getData();
    }

    private Node<T> findNode(T data) {
        if (this.head == null) {
            return null;
        }
        Node<T> current = this.head;
        while (current != null) {
            if (current.getData().equals(data)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public void deleteByValue(T data) {
        validate(data);
        if (this.head != null && this.head.getData().equals(data)) {
            this.head = this.head.getNext();
        }

        Node<T> foundPrevoiusNode = findPrevious(data);
        if (foundPrevoiusNode != null) {
            Node<T> nodeToDelete = foundPrevoiusNode.getNext();
            if (nodeToDelete != null) {
                foundPrevoiusNode.setNext(nodeToDelete.getNext());
            }
        }
    }

    private Node<T> findPrevious(T data) {
        Node<T> current = this.head;
        Node<T> next = current.getNext();

        while (current != null && next != null) {
            if (next.getData().equals(data)) {
                return current;
            }
            current = next;
            next = next.getNext();
        }
        return null;
    }

    public void deleteByPosition(int index) {
        if (index < 0) {
            return;
        }
        if (index == 0) {
            if (this.head != null) {
                this.head = this.head.getNext();
            }
        } else {
            Node<T> nodePreviousToDelete = findByIndex(index - 1);
            if (nodePreviousToDelete != null) {
                Node<T> nodeToDelete = nodePreviousToDelete.getNext();
                if (nodeToDelete != null) {
                    nodePreviousToDelete.setNext(nodeToDelete.getNext());
                }
            }
        }
    }

    private Node<T> findByIndex(int index) {
        if (index < 0) {
            return null;
        }
        int counter = 0;
        Node<T> current = this.head;

        while (current != null) {
            if (counter == index) {
                return current;
            }
            counter++;
            current = current.getNext();
        }
        return null;
    }

    public int getSize() {
        if (this.head == null) {
            return 0;
        }
        int result = 0;
        Node<T> current = this.head;

        while (current != null) {
            result++;
            current = current.getNext();
        }
        return result;
    }

}
