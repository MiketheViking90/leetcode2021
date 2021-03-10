package algo;

public class TrappingRainWater {
    public int trap(int[] height) {
        int N = height.length;
        int[] leftMax = new int[N];
        int[] rightMax = new int[N];

        int rMax = 0;
        for (int i = N-1; i >= 0; i--) {
            rightMax[i] = rMax;
            rMax = Math.max(rMax, height[i]);
        }

        int lMax = 0;
        for (int i = 0; i < N; i++) {
            leftMax[i] = lMax;
            lMax = Math.max(lMax, height[i]);
        }

        int[] water = new int[N];
        for (int i = 0; i < N; i++) {
            int h = Math.min(leftMax[i], rightMax[i]);
            water[i] = h - height[i];
        }
        int sum = 0;
        for (int diff : water) {
            sum += diff;
        }
        return sum;
    }
}
