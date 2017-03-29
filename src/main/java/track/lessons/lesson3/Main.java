package track.lessons.lesson3;

import java.util.LinkedList;

/**
 * Created by franck on 15.03.17.
 */
public class Main {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        System.out.println(list.remove(1));
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));


        System.out.println(list.size());

//        MyArrayList myArrayList = new MyArrayList();

//        System.out.println(myArrayList.size());
//        myArrayList.add(1);
//
//        System.out.println(myArrayList.size());
//        myArrayList.add(4);
//        System.out.println(myArrayList.size());
//        for(int i = 0; i < myArrayList.size(); i++) {
//            System.out.print(myArrayList.get(i));
//        }
//       myArrayList.remove(1);
//        for(int i = 0; i < myArrayList.size(); i++) {
//            System.out.print(myArrayList.get(i));
//        }
//        System.out.println();
//        for(int i = 0; i < 4; i++) {
//            myArrayList.add(4+i);
//        }
//        for(int i = 0; i < myArrayList.size(); i++) {
//            System.out.print(myArrayList.get(i));
//        }
//        myArrayList.remove(1);
//        for(int i = 0; i < myArrayList.size(); i++) {
//            System.out.print(myArrayList.get(i));
//        }
//
//        myArrayList.get(1);

    }
}
