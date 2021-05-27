package algo;

public class StockSpanner {

    int prevPrice = 0;
    int count = 1;

    public StockSpanner() {

    }

    public int next(int price) {
        if (price <= prevPrice) {
            count++;
        } else {
            count = 1;
        }

        prevPrice = price;
        return count;
    }

}
