public class Solution {
    
    // use two pointers, i and j, i to point to the result array, and j is moving to find the duplicate
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        
        // 1,1,1,2,2,3,4
        
        int i = 0, j = 1;
        for(j = 1; j < nums.length; j++){
            if(nums[j] != nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}