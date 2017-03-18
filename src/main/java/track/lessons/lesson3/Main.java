package track.lessons.lesson3;

public class Main {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.enqueue(1);
        myLinkedList.enqueue(2);
        myLinkedList.enqueue(3);
        System.out.println(myLinkedList.dequeu());
        System.out.println(myLinkedList.dequeu());


    }
}