public class Solution {

/*
暴力解法，三层循环 => 优化到两层循环

最优解法：
窗口类问题，重点是证明！i, j 可以单向移动！，j 不需要退回！
九章强化班，双指针，前向型

*/    
    
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int i = 0, j = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        
        for (i = 0; i < nums.length; i++) {
            
            while (j < nums.length && sum < s) {
                sum += nums[j];
                j ++;
            }
            
            if (sum >= s) {
                ans = Math.min(ans, j - i);  //易错点，跳出循环时，sum >= s， 此时 因为 
                                    //  j ++最后执行，已经跑到了最后一位的下一位，所以不需要 j - i + 1!!!!
            }
            
            sum -= nums[i];
        }
        
        if (ans == Integer.MAX_VALUE) {
            ans = 0;
        }
        return ans;
    }
}


