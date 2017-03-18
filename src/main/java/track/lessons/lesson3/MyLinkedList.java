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
    private Node tail;


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
        tail = new Node(null,null,0);
        header = new Node(tail, tail,0);
        length = 0;
        header.next = header.prev = header;
    }

    @Override
    void add(int item) {
        length++;
        tail = new Node(header.prev, header, item);
        tail.prev.next = tail;
        tail.next.prev = tail;
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

        final int value = tail.val;
        length--;
        tail.next.prev = tail.prev;
        tail.prev.next = header;
        tail = tail.prev;
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
        header.next.prev = header;
        return value;
    }

    @Override
    public void enqueue(int value) {
        length++;
        tail = new Node(header.prev, header, value);
        tail.prev.next = tail;
        header.prev = tail;
    }

}
