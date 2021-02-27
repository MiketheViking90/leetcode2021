package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt((int[] i) -> i[0]));

        int i = 0;
        int j = 0;
        List<int[]> merged = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];
        while (j < intervals.length) {
            int[] interval1 = intervals[i];
            int[] interval2 = intervals[j];

            if (isOverlap(start, end, interval2)) {
                end = Math.max(interval1[1], interval2[1]);
                j++;
            } else {
                merged.add(new int[]{start, end});
                i = j;
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        int size = merged.size();
        return merged.toArray(new int[size][2]);
    }

    private boolean isOverlap(int start, int end, int[] interval) {
        int intervalStart = interval[0];
        return start <= intervalStart && intervalStart <= end;
    }

    public static void main(String[] args) {
        MergeIntervals mi = new MergeIntervals();

        int[][] intervals = {{12, 15}, {1, 2}, {2, 5}, {8, 10}};
        int[][] merged = mi.merge(intervals);
        System.out.println(Arrays.deepToString(merged));
    }
}
