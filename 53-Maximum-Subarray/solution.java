/*
using prefixSum calculate the Sn
找到两个 sn, 使得后面的 si - sj 最大， (i > j) 


*/

public class Solution {
    public int maxSubArray(int[] nums) {
        int minSum = Integer.MAX_VALUE;
        int sum = 0;
        int ans = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            minSum = Math.min(minSum, sum);
            
            sum += nums[i];
            ans = Math.max(ans, sum - minSum);
        }
        return ans;
    }
}