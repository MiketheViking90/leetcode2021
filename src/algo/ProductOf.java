package algo;

public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        int[] products = new int[N];

        if (containsZero(nums)) {
            return products;
        }

        int product = getProduct(nums);
        for (int i = 0; i < N; i++) {
            int n = nums[i];
            int prodExceptSelf = product / n;
            products[i] = prodExceptSelf;
        }
        return products;
    }

    private static int getProduct(int[] nums) {
        int product = 1;
        for (int n : nums) {
            product *= n;
        }
        return product;
    }

    private static boolean containsZero(int[] nums) {
        for (int n : nums) {
            if (n == 0) {
                return true;
            }
        }
        return false;
    }
}
