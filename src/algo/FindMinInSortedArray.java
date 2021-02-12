package algo;

public class FindMinInSortedArray {
    public static int findMin(int[] nums) {
        if (!hasRotation(nums)) {
            return nums[0];
        }

        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = (hi + lo) / 2;
            int midNum = nums[mid];

            if (midNum > nums[mid+1]) {
                return nums[mid+1];
            } else if (midNum < nums[lo]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    private static boolean hasRotation(int[] nums) {
        int N = nums.length;
        return nums[0] > nums[N-1];
    }

    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        int val = findMin(nums);
        System.out.println(val);
    }
}
