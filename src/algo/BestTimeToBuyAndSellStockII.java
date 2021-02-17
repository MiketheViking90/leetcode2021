package algo;

public class BestTimeToBuyAndSellStockII {
    public static int maxProfit(int[] prices) {
        int N = prices.length;
        int profit = 0;

        for (int i = 1; i < N; i++) {
            int price0 = prices[i-1];
            int price1 = prices[i];

            if (price1 > price0) {
                profit += (price1-price0);
            }
        }
        return profit;
    }
}
