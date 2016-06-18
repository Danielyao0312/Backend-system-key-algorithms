public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        
        int len = nums.length;

		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			if (!map.containsKey(i)) {
				map.put(i, 1);
			} else {
				map.put(i, map.get(i) + 1);
			}
		}
        
        
		for (int key : map.keySet()) {
			if (map.get(key) > len / 3) {
				list.add(key);
			}
		}
		return list;
    }
}