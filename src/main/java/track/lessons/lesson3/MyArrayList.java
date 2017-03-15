package track.lessons.lesson3;

import java.util.NoSuchElementException;

/**
 * Должен наследовать List
 *
 * Должен иметь 2 конструктора
 * - без аргументов - создает внутренний массив дефолтного размера на ваш выбор
 * - с аргументом - начальный размер массива
 */
public class MyArrayList extends List {

    private int[] array;
    private int counter;

    public MyArrayList() {
        this(0);
    }

    public MyArrayList(int capacity) {
        array = new int[capacity];
        length = capacity;
    }

    @Override
    void add(int item) {

        if (counter >= length) {
            int[] arrayTemp = new int[length + 1];
            System.arraycopy(array,0 , arrayTemp, 0 , length );
            array = arrayTemp;
        }

        array[counter] = item;
        counter++;
        length = array.length;
    }

    @Override
    int remove(int idx) throws NoSuchElementException {
        if (idx >= 0 && idx < length) {
            final int item = array[idx];
            int[] arrayTemp = new int[length - 1];
            System.arraycopy(array ,0 , arrayTemp ,0 , idx);
            if (idx != arrayTemp.length) {
                System.arraycopy(array , idx + 1 , arrayTemp , idx , arrayTemp.length - 1);
            }
            array = arrayTemp;
            counter--;
            length = array.length;
            return item;
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    int get(int idx) throws NoSuchElementException {
        if (idx >= 0 && idx < length) {
            int item = array[idx];
            return item;
        } else {
            throw new NoSuchElementException();
        }
    }

}