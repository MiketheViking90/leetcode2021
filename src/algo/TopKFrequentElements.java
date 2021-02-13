package algo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    Map<Integer, Integer> intToCount = new HashMap<>();

    public int[] topKFrequent(int[] nums, int k) {
        for (int num : nums) {
            int cnt = intToCount.getOrDefault(num, 0);
            intToCount.put(num, cnt+1);
        }

        Comparator<Map.Entry<Integer, Integer>> countComparator = Map.Entry.comparingByValue();
        PriorityQueue<Map.Entry<Integer, Integer>> intCounts = new PriorityQueue<>(countComparator);
        for (Map.Entry<Integer, Integer> entry : intToCount.entrySet()) {
            if (intCounts.size() < k) {
                intCounts.offer(entry);
            } else {
                Map.Entry<Integer, Integer> top = intCounts.peek();
                if (top.getValue() < entry.getValue()) {
                    intCounts.poll();
                    intCounts.offer(entry);
                }
            }
        }


        int[] tops = new int[k];
        int idx = 0;
        while (!intCounts.isEmpty()) {
            int n = intCounts.poll().getKey();
            tops[idx++] = n;
        }
        return tops;
    }
}
