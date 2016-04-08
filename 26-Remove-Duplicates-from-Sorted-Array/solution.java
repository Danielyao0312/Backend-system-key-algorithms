public class Solution {
    //题目关键字：数组，已排好序的，只能in place替换，不能用额外数组，并且要求结果返回unique的长度。
    // 题解方法是双指针，一个指针只记录unique的并且帮助记录长度，一个指针往前找。
    // 从 nums[1]开始往后扫，只有遇到与前一个值不相等时，替换，并且维护的指针 p++
    
    public int removeDuplicates(int[] nums){
        if(nums.length == 0 || nums == null) return 0;
        int p = 1;
        int duplicate = nums[0];
        for(int i = 1; i < nums.length; i ++){
            if(nums[i] == duplicate){
                continue;
            }
            if(nums[i] != duplicate){
                nums[p] = nums[i];
                p++;
                duplicate = nums[i];
            }
        }
        return p;
    }
    
}