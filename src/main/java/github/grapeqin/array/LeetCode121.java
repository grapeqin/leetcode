package github.grapeqin.array;

public class LeetCode121 {

    public int maxProfit(int[] prices) {
        if (prices.length < 1) {
            return 0;
        }
        int minPrice = prices[0];
        int maxPrice = 0;
        for (int i = 0; i < prices.length; i++) {
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            }
            if (maxPrice < prices[i] - minPrice) {
                maxPrice = prices[i] - minPrice;
            }
        }
        return maxPrice;
    }
}
