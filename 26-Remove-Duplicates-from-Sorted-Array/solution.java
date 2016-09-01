public class Solution {
    
    // use two pointers, i and j, j to point to the result array, and i is moving to find the duplicate
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int index = 1;  //因为第一个数字,一定不是重复的,所以不予考虑, index 此时指向 length 的位置
        for (int i = 1; i < nums.length; i++) {  //因为下面要检查nums[i-1]位置,且第0位肯定包含在结果中,所以从1开始!
            if (nums[i] != nums[i - 1]) {
                nums[index ++] = nums[i];
            }
        }
        return index;
    }
}