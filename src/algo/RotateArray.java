package algo;

import java.util.Arrays;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int N = nums.length;
        k = k % N;
        int l = N-k;

        int[] head = new int[k];
        int[] tail = new int[l];

        System.arraycopy(nums, N-k, head, 0, k);
        System.arraycopy(nums, 0, tail, 0, N-k);

        System.arraycopy(head, 0, nums, 0, k);
        System.arraycopy(tail, 0, nums, k, N - k);
    }

    public static void main(String[] args) {
        RotateArray ra = new RotateArray();

        int[] nums = {1,2,3,4,5,6,7,8};
        int k = 3;
        ra.rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
