public class Solution {
    /*
    1. 计算当前点之前的最小值 min
    2. 当前天的 maxProfit = price - min 作为候选
    3. 用这个 maxprofit 和全局 max 比一下，更新全局 max 
    */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int curMin = prices[0];
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            curMin = Math.min(prices[i], curMin);
            maxProfit = Math.max(maxProfit, prices[i] - curMin);
        }
        
        return maxProfit;
    }
}
