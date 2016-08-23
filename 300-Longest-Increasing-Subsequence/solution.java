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
        
        int n = nums.length;
        int[] f = new int[n];
        int ans = 0;
        
        Arrays.fill(f, 1);
        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < i; j++)
            {
                if (nums[j] < nums[i]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            ans = Math.max(ans, f[i]);
        }
        
        return ans;
    }
}