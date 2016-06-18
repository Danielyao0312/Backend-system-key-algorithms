public class Solution {
	public int majorityElement(int[] nums) {
		int len = nums.length;
		if (len == 1) 	return nums[0];

		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			if (!map.containsKey(i)) {
				map.put(i, 1);
			} else {
				map.put(i, map.get(i) + 1);
			}
		}
    
        int res = 0;
		for (int key : map.keySet()) {
			if (map.get(key) > len / 2) {
				res = key;
			}
		}
		return res;
    }

}