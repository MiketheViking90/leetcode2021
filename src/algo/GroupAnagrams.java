package algo;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> sortedToAnagrams = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);

            List<String> anagrams = sortedToAnagrams.getOrDefault(key, new ArrayList<>());
            sortedToAnagrams.put(key, anagrams);
            anagrams.add(str);
        }

        return new ArrayList<>(sortedToAnagrams.values());
    }

    public static void main(String[] args) {
        GroupAnagrams ga = new GroupAnagrams();

        String[] words = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> anagrams = ga.groupAnagrams(words);
        System.out.println(anagrams);

    }
}
