/*
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
Subscribe to see which companies asked this question

*/

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
 		Map<Integer, Integer> map1 = new HashMap<>();
 		Map<Integer, Integer> map2 = new HashMap<>();
 		List<Integer> list = new ArrayList<>();

 		for (int i : nums1) {
 			if (!map1.containsKey(i)) {
 				map1.put(i, 1);
 			} else {
 				map1.put(i, map1.get(i) + 1);
 			}
 		}

 		for (int i : nums2) {
 			if (!map2.containsKey(i)) {
 				map2.put(i, 1);
 			} else {
 				map2.put(i, map2.get(i) + 1);
 			}
 		}

 		// add to list
 		for (int key : map1.keySet()) {
 			if (map2.containsKey(key)) {
 				int size = Math.min(map1.get(key), map2.get(key));
 				for (int i = 0; i < size; i++) {
 					list.add(key);
 				}
 			}
 		}

 		//list to array:
 		int[] res = new int[list.size()];
 		int j = 0;
 		for (int i : list) {
 			res[j++] = i;
 		}
 		return res;

    }
}