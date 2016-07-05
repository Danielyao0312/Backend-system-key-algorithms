// similarly to best time to buy and sell stock
// calculate prefixSum[], the biggest difference between prefixSum, is the result.
// when calculate sum, always find the minSum before current element, 

public class Solution {
    // public int maxSubArray(int[] nums) {
    //     if (nums == null || nums.length == 0) {
    //         return 0;
    //     }
        
    //     int sum = 0, minSum = 0, max = Integer.MIN_VALUE;
    //     for (int i = 0; i < nums.length; i++) {
    //         sum += nums[i]; // 前 i 项和
    //         max = Math.max(max, sum - minSum); // max is globally the max, compare it with the sum - minSum
    //         minSum = Math.min(minSum, sum); // sofar minSum
            
            
    //     }
    //     return max;
    // }
    
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int maxEndingHere = 0;
        int maxSofar = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }
            maxEndingHere += nums[i];
            maxSofar = Math.max(maxSofar, maxEndingHere);
        }
        return maxSofar;
    }
}
