package track.lessons.lesson1;

import java.io.File;

/**
 * Created by franck on 06.03.17.
 */

public class Main {
    public static void main(String[] args) {
        File file  = new File("./words.txt");
        CountWords countWords = new CountWords();
        try {
            System.out.println(countWords.countNumbers(file));
            System.out.println(countWords.concatWords(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
