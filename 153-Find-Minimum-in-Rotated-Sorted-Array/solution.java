public class Solution {
    
    /*
    1. corner case:
        if nums are not rotated (nums[start] < nums[end]), return the first one
    
    solution:
    1. cut on the left part : A > nums[start], find the right(start = mid)
    2. else cut on the right,  find the left(end = mid)
    */
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        
        int start = 0;
        int end = nums.length - 1;
        int mid;
        
        if (nums[start] < nums[end]) {
            return nums[0];
        }
        
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] >= nums[start]) {
               start = mid; 
            } else {
                end = mid;
            }
        }
        if (nums[start] < nums[end]) {
            return nums[start];
        } else {
            return nums[end];
        }
        
    }
}