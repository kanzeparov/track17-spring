package track.lessons.lesson3;

import java.util.NoSuchElementException;

/**
 * Должен наследовать List
 * Односвязный список
 */
public class MyLinkedList extends List implements Queue, Stack {
    /**
     * private - используется для сокрытия этого класса от других.
     * Класс доступен только изнутри того, где он объявлен
     * <p>
     * static - позволяет использовать Node без создания экземпляра внешнего класса
     */
    private Node header;
    private Node headerEnd;
    private Node firstElement;
    private Node newElement;

    private static class Node {
        Node prev;
        Node next;
        int val;

        Node(Node prev, Node next, int val) {
            this.prev = prev;
            this.next = next;
            this.val = val;
        }
    }

    public MyLinkedList() {
        headerEnd = new Node(null,null,0);
        header = new Node(headerEnd,headerEnd,0);
        length = 0;
        header.next = header.prev = header;
    }

    @Override
    void add(int item) {
        length++;
        newElement = new Node(header.prev, header, item);
        newElement.prev.next = newElement;
        newElement.next.prev = newElement;
    }

    @Override
    int remove(int idx) throws NoSuchElementException {
        Node temp = header.next;
        do {
            if (idx == 0) {
                final int tempVal = temp.val;
                length--;
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                return tempVal;
            }
            temp = temp.next;
            idx--;
        }
        while (temp != header);
        throw new NoSuchElementException();
    }

    @Override
    int get(int idx) throws NoSuchElementException {
        if (length > 0) {
            Node temp = header.next;
            do {
                if (idx == 0) {
                    return temp.val;
                }
                temp = temp.next;
                idx--;
            }
            while (temp != header);
        }
        throw new NoSuchElementException();
    }

    @Override
    public void push(int value) {
        this.add(value);
    }

    @Override
    public int pop() throws NoSuchElementException {

        if (length == 0) {
            throw new NoSuchElementException();
        }

        final int value = newElement.val;
        length--;
        newElement.next.prev = newElement.prev;
        newElement.prev.next = header;
        newElement = newElement.prev;
        return value;
    }

    @Override
    public int dequeu() throws NoSuchElementException {
        if (length == 0) {
            throw new NoSuchElementException();
        }
        length--;
        int value = header.next.val;
        header.next = header.next.next;
        header.next.next.prev = header;
        return value;
    }

    @Override
    public void enqueue(int value) {
        length++;
        firstElement = new Node(header, header.next, value);
        header.next.prev = firstElement;
        header.next = firstElement;
    }

}
