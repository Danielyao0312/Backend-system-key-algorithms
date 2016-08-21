/*
using prefixSum calculate the Si - sj 即为 (i, j) 中的和
找到两个 sn, 使得后面的 si - sj 最大， (i > j) 


*/

public class Solution {
    public int maxSubArray(int[] nums) {
        int minSum = Integer.MAX_VALUE;
        int sum = 0;
        int ans = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            minSum = Math.min(minSum, sum); // 找到当前 sum 之前的最小 sum
            
            sum += nums[i];  // 更新得到当前的 sum 
            ans = Math.max(ans, sum - minSum);  // 用当前 sum - minSum, 得到一个候选的可能的全局的 subarray 和
        }
        return ans;
    }
}