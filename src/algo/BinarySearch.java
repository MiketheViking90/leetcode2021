package algo;

public class BinarySearch {
    public static int binarySearch(int[] nums, int k) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = (hi + lo) / 2;

            int midNum = nums[mid];
            if (midNum == k) {
                return mid;
            } else if (midNum < k) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,7,8,9,12,13,15,123};
        int idx = binarySearch(nums, 123);
        System.out.println(idx);
    }
}
