/*
1. hashmap : key : nums[i],  value: key
2. a + b = tar => a = tar - b

*/

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                break;
            }
            else {
                map.put(nums[i], i);
            }
        }
        return res;
    }
}