package algo;

import java.util.*;

public class AlienDictionary {
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> adj = new HashMap<>();
        Map<Character, Integer> charCounts = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.put(c, new ArrayList<>());
                charCounts.put(c, 0);
            }
        }


        for (int i = 0; i < words.length - 1; i++) {
            String word0 = words[i];
            String word1 = words[i+1];

            boolean isPrefix = word0.length() > word1.length() && word0.startsWith(word1);
            if (isPrefix) {
                return "";
            }

            for (int j = 0; j < word0.length(); j++) {
                char c0 = word0.charAt(j);
                char c1 = word1.charAt(j);
                if (c0 != c1) {
                    int count = charCounts.get(c1);
                    charCounts.put(c1, count+1);

                    adj.get(c0).add(c1);
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for (char c : charCounts.keySet()) {
            if (charCounts.get(c) == 0) {
                queue.offer(c);
            }
        }

        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);

            for (char nextChar : adj.get(c)) {
                int count = charCounts.get(nextChar);
                charCounts.put(nextChar, count-1);
                if (charCounts.get(nextChar) == 0) {
                    queue.offer(nextChar);
                }
            }
        }

        if (sb.length() < charCounts.size()) {
            return "";
        }
        return sb.toString();
    }
}
