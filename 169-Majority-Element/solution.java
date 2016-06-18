public class Solution {
    public int majorityElement(int[] nums) {
        // best solution: Moore's voting algorithm
        int major = nums[0], count = 1;
        
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                major = nums[i];
                count = 1;
            } else if (nums[i] == major) {
                count++;
            } else { // nums[i] != major
                count--;
            }
        }
        
        return major;
    }
    
    // solution 2: hashtable: {key : element in nums, value : counts}, first traversal construct the hashtable, second traversal find the majority value;

// 	public int majorityElement(int[] nums) {
// 		int len = nums.length;
// 		if (len == 1) 	return nums[0];

// 		Map<Integer, Integer> map = new HashMap<>();
// 		for (int i : nums) {
// 			if (!map.containsKey(i)) {
// 				map.put(i, 1);
// 			} else {
// 				map.put(i, map.get(i) + 1);
// 			}
// 		}
//      
        // int res = 0;
// 		for (int key : map.keySet()) {
// 			if (map.get(key) > len / 2) {
// 				res = key;
// 			}
// 		}
        // return res

//     }

}