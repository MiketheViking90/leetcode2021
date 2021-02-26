package algo;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {
    public String reorganizeString(String S) {
        Map<Character, Integer> charCounts = getCharCounts(S);
        PriorityQueue<CharCount> pq = toHeap(charCounts);
        if (isCountOverHalf(S, pq.peek().count)) {
            return "";
        }
        return arrangeCounts(pq);
    }

    private boolean isCountOverHalf(String S, int count) {
        return count > ((S.length() + 1) /2);
    }

    private Map<Character, Integer> getCharCounts(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            int cnt = map.getOrDefault(c, 0);
            map.put(c, cnt+1);
        }
        return map;
    }

    private PriorityQueue<CharCount> toHeap(Map<Character, Integer> charCounts) {
        PriorityQueue<CharCount> pq = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> e : charCounts.entrySet()) {
            CharCount charCount = new CharCount(e.getKey(), e.getValue());
            pq.offer(charCount);
        }
        return pq;
    }

    private String arrangeCounts(PriorityQueue<CharCount> charCounts) {
        StringBuilder sb = new StringBuilder();
        while (charCounts.size() >= 2) {
            CharCount charCount1 = charCounts.poll();
            CharCount charCount2 = charCounts.poll();
            append(charCounts, sb, charCount1);
            append(charCounts, sb, charCount2);
        }
        if (charCounts.size() == 1) {
            sb.append(charCounts.peek().c);
        }
        return sb.toString();
    }

    private void append(PriorityQueue<CharCount> charCounts, StringBuilder sb, CharCount charCount) {
        char c = charCount.c;
        int count = charCount.count;
        sb.append(c);
        if (count > 1) {
            charCounts.offer(new CharCount(c, count-1));
        }
    }

    class CharCount implements Comparable<CharCount>{
        char c;
        int count;

        public CharCount(Character c, Integer count) {
            this.c = c;
            this.count = count;
        }

        @Override
        public int compareTo(CharCount o) {
            return Integer.compare(o.count, this.count);
        }
    }

    public static void main(String[] args) {
        String s = "vvv12";
        ReorganizeString rs = new ReorganizeString();
        String re = rs.reorganizeString(s);
        System.out.println(re);
    }
}
