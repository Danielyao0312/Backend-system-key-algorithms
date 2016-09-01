public class Solution {
    
    // use two pointers, i and j, j to point to the result array, and i is moving to find the duplicate
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        
        // 1,1,1,2,2,3,4
        int j = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i-1]) {
                nums[j++] = nums[i];
            }
        }
        return j;
        
    }
}