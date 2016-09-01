public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums == null) return 0;
        
        int amount = 1;
        int p = 1;
        
        // amount 用于记录同一个元素的出现的重复的次数，当重复数为1时，添加进数组，>=2时则不能添加
        for(int i = 1; i < nums.length; i ++) {
            if(nums[i] == nums[i - 1] && amount == 1){
                nums[p++] = nums[i];
                amount++;
            }
            if(nums[i] != nums[i - 1]){
                nums[p++] = nums[i];
                amount = 1;
            }
        }
        
        return p;
    }
}