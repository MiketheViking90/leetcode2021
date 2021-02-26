package algo;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int N = s.length();

        Map<Character, Integer> tCounter = new HashMap<>();
        for (char c : t.toCharArray()) {
            int cnt = tCounter.getOrDefault(c, 0);
            tCounter.put(c, cnt+1);
        }


        int substrLength = Integer.MAX_VALUE;
        String substring = "";
        Map<Character, Integer> sCounter = new HashMap<>();

        int i = 0;
        int j = 0;
        while (j < N) {
            char c = s.charAt(j++);
            int cnt = sCounter.getOrDefault(c, 0);
            sCounter.put(c, cnt+1);

            while (isSubmap(tCounter, sCounter)) {
                if (j-i < substrLength) {
                    substrLength = j-i;
                    substring = s.substring(i, j);
                }

                c = s.charAt(i++);
                cnt = sCounter.getOrDefault(c, 0);
                sCounter.put(c, cnt-1);
            }
        }
        return substring;
    }

    private boolean isSubmap(Map<Character, Integer> tCounter, Map<Character, Integer> sCounter) {
        if (!sCounter.keySet().containsAll(tCounter.keySet())) {
            return false;
        }

        for (Map.Entry<Character, Integer> tEntry : tCounter.entrySet()) {
            char c = tEntry.getKey();
            int count = tEntry.getValue();

            if (sCounter.get(c) < count) {
                return false;
            }
        }
        return true;
    }
}
