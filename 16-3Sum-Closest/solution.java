public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3) return 0;
        
        // a + b + c = sum,  if sum > target, move high to left, if sum < target, move low to right, 
        
        //始终记住，要维护和返回的变量，放在外边
        Arrays.sort(nums);
        int closet = Integer.MAX_VALUE;
        int res = 0;
        
        for(int i = 0; i < nums.length - 2; i++) {
            int low = i + 1;
            int high = nums.length - 1;
            
            while(low < high){
                int sum = nums[i] + nums[low] + nums[high];
                int distance = Math.abs(sum - target);
                
                // if distance < closet, update the closet, and also update the return value
                if(distance < closet){
                    closet = distance;
                    res = sum;
                }
                
                if(sum < target){
                    low++;
                }else if(sum > target){
                    high--;
                }else{ // sum = target
                    return sum;
                }
            }
            
            
        }
        
        return res;
    
    }
}