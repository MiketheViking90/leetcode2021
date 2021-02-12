package algo;

public class SearchInSortedArray {
    public static int search(int[] nums, int target) {
        int rotateIndex = getRotateIndex(nums);
        int rotateNum = nums[rotateIndex];

        if (target == rotateNum) {
            return rotateNum;
        } else if (target < rotateNum) {
            return binarySearch(nums, target, 0, rotateIndex - 1);
        } else {
            return binarySearch(nums, target, rotateIndex+1, nums.length);
        }
    }

    private static int binarySearch(int[] nums, int target, int lo, int hi) {
        while (lo <= hi) {
            int mid = (hi + lo) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    private static int getRotateIndex(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;

        if (nums[lo] < nums[hi]) {
            return 0;
        }

        while (lo <= hi) {
            int mid = (hi + lo) / 2;
            int midVal = nums[mid];

            if (midVal > nums[mid+1]) {
                return mid + 1;
            } else if (midVal > nums[lo]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }
}
