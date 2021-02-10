package algo;

import java.util.Arrays;

public class ContainsDuplicates {
    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            int n1 = nums[i-1];
            int n2 = nums[i];

            if (n1 == n2) {
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        boolean b = containsDuplicate(nums);
        System.out.println(b);
    }
}
