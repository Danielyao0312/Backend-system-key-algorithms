public class Solution {
    public int maxProfit(int[] prices) {
        //corner cases:
        if(prices.length == 0 || prices == null)    return 0;
        
        int maxProfit = 0;
        int sofarMin = prices[0];
        
        for(int i = 1; i < prices.length; i ++) {
            int cur = prices[i];
            sofarMin = Math.min(sofarMin, cur);
            maxProfit = Math.max(maxProfit, cur - sofarMin);
        }
        
        return maxProfit;
    }
}