public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
     
    /*
    1. 枚举每一天，计算当前天之前的最小，然后 nums[i] - min 作为一个候选的最大
    2. 找到这个最大
    */ 
    public int maxProfit(int[] nums) {
        
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        
        int max = Integer.MIN_VALUE;
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i] - min);
            min = Math.min(min, nums[i]);
        }
        return max;
    }
}