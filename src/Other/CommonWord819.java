package Other;

import java.util.*;

public class CommonWord819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        String normal = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();

        String[] words = normal.split("\\s");

        Set<String> bannedWords = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> wordCount = new HashMap<>();

        Arrays.stream(words).filter(word -> !bannedWords
                            .contains(word))
                            .forEach(word ->
                                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1));

        return Collections.max(wordCount.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
