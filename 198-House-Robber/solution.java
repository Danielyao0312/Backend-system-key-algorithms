/*
state:
	 dp[i] = 抢劫前 i 个房间能得到的最大收益

function:  1. 如果 nums[i] 被抢，
            dp[i] = dp[i - 2] + nums[i];
          2. 如果 nums[i] 不被抢,
           dp[i] = dp[i - 1]
           
           取两者的最大值为 dp[i] !!!!

initial: dp[0] = 0, dp[1] = nums[0];

answer: dp[n];

*/

public class Solution {
    public int rob(int[] nums) {
    	if (nums == null || nums.length == 0) {
    		return 0;
    	}

        int n = nums.length;

        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i <= n; i++) {
        	dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]); //出错点，下标的对应，应该为 i - 1
        }

        return dp[n];
    }
}