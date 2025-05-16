package task2;

import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    public static void main(String[] args) {
        String text = "яблоко яблока яблоко груша груша";
        Map<String, Integer> result = countWords(text);
        System.out.println(result);
    }

    public static Map<String, Integer> countWords(String text) {
        Map<String, Integer> wordCount = new HashMap<>();
        if (text == null || text.isEmpty()) {
            return wordCount;
        }

        String[] words = text.split("\\s+");
        for (String word : words) {
            word = word.toLowerCase();
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        return wordCount;
    }


}
