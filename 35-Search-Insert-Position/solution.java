/*
find first position >= target
*/

public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0 || nums == null){
            return 0;
        }
        
        int start = 0, end = nums.length - 1, mid = 0;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (nums[start] >= target) {
            return start;
        } else if (nums[end] >= target) {
            return end;
        } else {
            return nums.length;
        }
    }
}