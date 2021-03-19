package algo;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int N = nums.length;

        int[] lProds = new int[N];
        int[] rProds = new int[N];

        int prod = 1;
        lProds[0] = prod;
        for (int i = 1; i < N; i++) {
            int n = nums[i-1];
            lProds[i] = n * lProds[i-1];
        }

        rProds[N-1] = 1;
        for (int i = N-2; i >= 0 ; i--) {
            int n = nums[i+1];
            rProds[i] = n * rProds[i+1];
        }

        int[] prods = new int[N];
        for (int i = 0; i < N; i++) {
            prods[i] = lProds[i] * rProds[i];
        }
        return prods;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,5};
        int[] products = productExceptSelf(nums);
        System.out.println(Arrays.toString(products));
    }
}
