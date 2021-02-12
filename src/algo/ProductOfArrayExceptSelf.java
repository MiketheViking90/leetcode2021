package algo;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int N = nums.length;

        int[] lProds = new int[N];
        int[] rProds = new int[N];

        int prod = 1;
        lProds[0] = 1;
        for (int i = 1; i < N; i++) {
            int n = nums[i-1];
            prod *= n;
            lProds[i] = prod;
        }

        prod = 1;
        rProds[N-1] = 1;
        for (int i = N-2; i >= 0 ; i--) {
            int n = nums[i+1];
            prod *= n;
            rProds[i] = prod;
        }

        int[] products = new int[N];
        for (int i = 0; i < N; i++) {
            prod = lProds[i] * rProds[i];
            products[i] = prod;
        }
        return products;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,3,4,5};
        int[] products = productExceptSelf(nums);
        System.out.println(Arrays.toString(products));
    }
}
