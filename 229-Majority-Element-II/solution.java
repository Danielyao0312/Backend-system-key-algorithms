public class Solution {
    
    // best solution:
    // there are at most two possible majority elements
    // 3 situations :
    // 1. count == 0 : num1 = nums[i] , count = 1
    // 2. 数字与 majority 相等 :  num1 == nums[i]  count1 ++
    // 3. 当前数字 != majority :   count --;
    
     public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        
        int len = nums.length;
        if (len == 0)   return list;
        
        int num1 = 0, num2 = 0;
        int count1 = 0, count2 = 0;
        
        for (int i = 0; i < len; i++) {
            int val = nums[i];
            
            if (num1 == val) {
                count1 ++;
            } else if (num2 == val) {
                count2 ++;
            } else if (count1 == 0) {
                num1 = val;
                count1 = 1;
            } else if (count2 == 0) {
                num2 = val;
                count2 = 1;
            } else {
                count1 --;
                count2 --;
            }
        }
        
        if (isMoreThanOneThird(num1, nums)) {
            list.add(num1);
        }
        if (num2 != num1 && isMoreThanOneThird(num2, nums) ) {
            list.add(num2);
        }
        return list;
        
    }
    
    private boolean isMoreThanOneThird(int val, int[] nums) {
        int count = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (val == nums[i]) {
                count++;
            }
        }
        if(count > len / 3)     return true;
        return false;
    }
    
    
    
    
    
    // using hashmap, O(n) space, O(n) time
//     public List<Integer> majorityElement(int[] nums) {
//         List<Integer> list = new ArrayList<>();
        
//         int len = nums.length;
//         if (len == 0)   return list;
        
// 		Map<Integer, Integer> map = new HashMap<>();
// 		for (int i : nums) {
// 			if (!map.containsKey(i)) {
// 				map.put(i, 1);
// 			} else {
// 				map.put(i, map.get(i) + 1);
// 			}
// 		}
        
// 		for (int key : map.keySet()) {
// 			if (map.get(key) > len / 3) {
// 				list.add(key);
// 			}
// 		}
// 		return list;
//     }
}