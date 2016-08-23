/*
单序列，最长 => DP 问题
1. state:  f[i] 表示以 i 结尾的，最长 subsequence 是多长？
2. function: f[i] = Max(f[j]) + 1   (j < i && nums[j] < nums[i])
3. initial : f[0 .. n] = 1;
4. ans : Max(f[i])

*/

public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int ans = Integer.MIN_VALUE;
        int localMax = 0;
        int n = nums.length;
        int[] dp = new int[n];
        
        //initial:
        Arrays.fill(dp, 1);
        
        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < i; j++) 
            {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            
            ans = Math.max(ans, dp[i]);
        }

        return ans;
        
    }
}