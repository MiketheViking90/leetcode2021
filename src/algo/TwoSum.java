package algo;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int[] idx = new int[2];

        Map<Integer, Integer> nToIdx = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            nToIdx.put(n, i);
        }

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int complement = target - n;
            if (nToIdx.containsKey(complement)) {
                int j = nToIdx.get(complement);
                if (i != j) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public int[] twoSum1(int[] nums, int target) {
        int N = nums.length;
        Map<Integer, Integer> nToIdx = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int n = nums[i];
            nToIdx.put(n, i);
        }

        for (int i = 0; i < N; i++) {
            int n = nums[i];
            int c = target - n;

            if (nToIdx.containsKey(c)) {
                int idx = nToIdx.get(c);
                if (idx > i) {
                    return new int[]{i, idx};
                }
            }
        }
        return null;
    }

}
