package track.lessons.lesson5generics;

import java.util.*;

import track.util.Util;

import javax.print.DocFlavor;

/**
 *
 */
public class Cypher {

    public static final int SYMBOL_DIST = 32;

    private Map<Character, Integer> readData(String data) {
        Map<Character, Integer> map = new HashMap<>();
        Integer count = 0;
        for (int i = 0; i < data.length(); i++) {
            char ch = data.charAt(i);
            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
                if (ch < 'Z') {
                    ch += SYMBOL_DIST;
                }

                if (map.containsKey(ch) == false) {
                    map.put(ch, 0);
                } else {
                    int key = map.get(ch);
                    key++;
                    map.put(ch, key);
                }
                // Если это буква, то собираем частотную информацию



            }
        }
        return map;
    }

    /**
    На вход приходит текст
    1. Считываем readData() и получаем мапу {Символ -> Кол-во употреблений}
    2. Далее нам нужно отсортировать пары ключ-значение по значению
     (Называются{@code List<Map.Entry<Character, Integer>>})
     (то есть по частоте употребления). Для этого можно создать список этих пар и отсортировать список.
     У java.lang.List есть вспомогательный метод {@link List#sort(Comparator)}
     Где Comparator - это логика сравнения объектов.

     3. После того, как получен отсортированный список {@code List<Map.Entry<Character, Integer>>} нужно превратить его
        обратно в Map для того, чтобы иметь быстрый доступ get().

     */
    public Map<Character, Integer> buildHist(String data) {
        Map<Character, Integer> map = readData(data);
        List<Map.Entry<Character, Integer>> list = new LinkedList<map.Entry<Character, Integer>>();
        list.sort(new MapComparator());


        Map<Character, Integer> sorted = new LinkedHashMap<>();
        for(Map.Entry<Character, Integer> li: list) {

        }
        return new HashMap<>(map);
    }

    public class MapComparator implements Comparator<Map.Entry<Character, Integer>> {

        @Override
        public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
            return o1.getKey() - o2.getKey();
        }

    }

    /**
     * Заменяем символы зашифрованного текста по таблицам частот
     *
     * @param in - отсортированный по частоте алфавит для основного текста
     * @param out - отсортированный по частоте алфавит для шифрованного текста
     * @param encrypted - зашифрованный текст
     * @return расшифрованный текст
     */
    public String merge(List<Character> in, List<Character> out, String encrypted) {
        StringBuilder decrypted = new StringBuilder();
        for(int i = 0; i < encrypted.length(); i++) {
            if (in.contains((Character)encrypted.charAt(i))) {
                decrypted.append(out.get(in.indexOf(encrypted.charAt(i))));
            }
        }

        return new String(decrypted);
    }

    public static void main(String[] args) {
        Cypher cypher = new Cypher();

        Map<Character, Integer> dataHist = cypher.buildHist(Util.readFile("data.txt"));

        String encryptedText = Util.encrypt(Util.readFile("toEncrypt.txt"));
        Map<Character, Integer> encryptedHist = cypher.buildHist(encryptedText);


        String result = cypher.merge(
                new LinkedList<>(dataHist.keySet()),
                new LinkedList<>(encryptedHist.keySet()),
                encryptedText);
        System.out.println(result);

    }

}



