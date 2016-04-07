public class Solution{
	//this is for something to commit
	//add for roll back

	public int[] twoSum(int[] nums, int target){
		HashMap<Integer, Integer> map = new HashMap<>();
		int[] result = new int[2];
		int len = nums.length;
		for(int i = 0; i < len; i++) {
			if(map.containsKey(target - nums[i])){
				result[0] = map.get(target - nums[i]);
				result[1] = i;
				break;
            }else{
        	    map.put(nums[i], i);
            }
        }
		return result;
    }
}