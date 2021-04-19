package algo;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int N = nums.length;
        int[] sums = new int[N+1];

        for (int i = 0; i < N; i++) {
            sums[i] = sums[i-1] + nums[i-1];
        }

        int cnt = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i+1; j < N; j++) {
                if (sums[j] - sums[i] == k) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
