package track.lessons.lesson3;

/**
 * Created by franck on 16.03.17.
 */
public interface Queue {
    void enqueue(int value); // поместить элемент в очередь

    int dequeu(); // вытащить первый элемент из очереди
}
