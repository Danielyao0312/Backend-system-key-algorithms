public class Solution {
    
    //similar to 3sum, a + b + c = sum -> a + b = sum - c , let distance = abs(target - (a + b)), find min(distance)
    public int threeSumClosest(int[] nums, int sum) {
        if(nums == null || nums.length < 3) return 0;
            
        Arrays.sort(nums);
                
        int min = Integer.MAX_VALUE;
        int res = 0;
        
        for(int i = 0; i < nums.length - 2; i++) {
            int target = sum - nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            
            // do two sum, target, and a + b = target, a go right, b go left, revise the dis
            while(j < k){
                int ss = nums[j] + nums[k];
                int dis = Math.abs(target - (nums[j] + nums[k]));
                
                if(dis < min){ //update min and result
                    min = dis;
                    res = nums[i] + nums[j] + nums[k];
                }       
                
                if(ss > target){
                    k--;
                }else if(ss < target){
                    j++;
                }else{
                    return res;
                }
          
            }
            
        }
        return res;
    }
}