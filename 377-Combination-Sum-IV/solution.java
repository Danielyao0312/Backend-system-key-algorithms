public class Solution {
    /*
    1. state: f[i] 表示当 target 为 i 的时候的组合总数
    2. function: eg. f[4] = (f[3] + f[1], f[2] + f[2], 
    f[i] = f[i] + f[i - x] , for x in nums
    
    */
    
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //dp[i] -> number of combination for target;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            // target = 3
            //1 2 
            for (int j = 0; j < nums.length && nums[j] <= i; j++) {
                   dp[i] += dp[i - nums[j]]; //i < nums[j] 
            }
        }
        return dp[target];
    }

}