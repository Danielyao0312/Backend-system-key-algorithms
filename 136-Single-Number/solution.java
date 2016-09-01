public class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.remove(i);
            }
        } 
        for (Integer key : map.keySet()) {
            res = key;
            break;
        }
        return res;
    }
}