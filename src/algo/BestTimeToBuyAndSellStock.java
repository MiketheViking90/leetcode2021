package algo;

public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int N = prices.length;
        int[] maxAfter = new int[N];
        int max = 0;

        for (int i = N-1; i >= 0; i--) {
            int p = prices[i];
            max = Math.max(max, p);

            maxAfter[i] = max;
        }

        int maxProfit = 0;

        for (int i = 0; i < N; i++) {
            int profit = maxAfter[i] - prices[i];
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }
}
