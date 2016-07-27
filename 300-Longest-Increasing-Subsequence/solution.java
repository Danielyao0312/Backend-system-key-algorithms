public class Solution {
    /*
    state: f[i] 表示以 nums[i] 结尾的 LIS 的长度
    function: f[i] = 比 i 小的之前的所有 j, 如果 nums[j] <= nums[i], 那么则f[j] + 1是一个可能候选的 candidate，我们选出这些 candidate 中最大的
    所以:  f[i] = max {f[j] + 1}  (j < i && nums[j] <= nums[i])
    initial: dp[1...n-1] = 1
    answer: max{dp[1...n-1]}
    */
    
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int res = 0;
        
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1; // 易错点！开始时要把所有的dp 赋值成1， 因为如果举个列子，4,1, 到1的时候，因为下降了，所以它的 dp[1] = 1， 如果不赋值进行比较，则会为0！
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}