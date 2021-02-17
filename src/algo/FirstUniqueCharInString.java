package algo;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharInString {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            int cnt = map.getOrDefault(c, 0);
            map.put(c, cnt+1);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isUnique(c, map)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isUnique(char c, Map<Character, Integer> map) {
        return map.get(c) == 1;
    }
}
