import java.util.NoSuchElementException;

public class LinkedList {
    static private class Node {
        public Node next;
        public int value;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size = 0;


    public void addFirst(int value) {
        var node = new Node(value);
        if(isEmpty()) {
            first = last = node;
        } else {
            node.next = first;
            first = node;
        }
        size++;
    }

    public void addLast(int value) {
        var node = new Node(value);
        if(isEmpty()) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }

        size++;
    }

    public boolean contains (int value) {
        return indexOf(value) != -1;
    }

    public void deleteFirst() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }

        if(first == last) {
            first = last = null;
            return;
        }

        var temp = first.next;
        first.next = null;
        first = temp;

        size--;
    }

    public void deleteLast() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }

        if(first == last) {
            first = last = null;
            return;
        }

        var current = first;
        while(isNotLastNode(current)) {
            if(nextNodeIsLastNode(current)) {
                break;
            }
            current = current.next;
        }
        current.next = null;
        last = current;

        size--;
    }

    private boolean isNotLastNode(Node current) {
        return current.next != null;
    }

    private boolean nextNodeIsLastNode(Node current) {
        return current.next == last;
    }

    public int indexOf(int value) {
        var counter = 0;
        var current = first;
        while(current != null) {
            if(current.value == value) {
                return counter;
            }
            current = current.next;
            counter++;
        }
        return  -1;
    }

    private Node getPrevious(Node node) {
        if(first == last) {
            throw new NoSuchElementException();
        }

        var current = first;
        while (current.next != null) {
            if(current.next == node) {
                break;
            }
            current = current.next;
        }
        return current;
    }

    private boolean isEmpty() {
        return first == null;
    }

    public int getSize() {
        return size;
    }
}
