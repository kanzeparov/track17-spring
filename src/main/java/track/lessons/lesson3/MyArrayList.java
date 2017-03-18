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
    private int defaultCapacity = 10;

    public MyArrayList() {
        array = new int[defaultCapacity];
        length = counter;
    }

    public MyArrayList(int capacity) {
        array = new int[capacity];
        length = counter;
    }

    @Override
    void add(int item) {

        if (counter >= array.length) {
            int[] arrayTemp = new int[array.length * 2 + 1];
            System.arraycopy(array,0 , arrayTemp, 0 , array.length );
            array = arrayTemp;
        }

        array[counter] = item;
        counter++;
        length = counter;
    }

    @Override
    int remove(int idx) throws NoSuchElementException {
        if (idx >= 0 && idx < length) {
            final int item = array[idx];
            System.arraycopy(array , idx + 1 , array, idx , length - 1);
            counter--;
            length = counter;
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