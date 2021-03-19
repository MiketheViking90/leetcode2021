package algo;

public class TrappingRainWater {
    public int trap(int[] height) {
        int N = height.length;
        int[] leftMax = new int[N];
        int[] rightMax = new int[N];

        int rMax = 0;
        for (int i = N-2; i >= 0; i--) {
            rMax = Math.max(rMax, height[i]);
            rightMax[i] = rMax;
        }

        int lMax = 0;
        for (int i = 1; i < N-1; i++) {
            lMax = Math.max(lMax, height[i]);
            leftMax[i] = lMax;
        }

        int sum = 0;
        for (int i = 1; i < N-1; i++) {
            int h = Math.min(leftMax[i], rightMax[i]);
            sum += (h - height[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
        TrappingRainWater trw = new TrappingRainWater();
        int sum = trw.trap(heights);
        System.out.println(sum);
    }
}
