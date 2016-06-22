public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null)      return null;
        
        Set<Integer> set = new HashSet<>();
        Set<Integer> interset = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (set.contains(i)) {
                interset.add(i);
            }
        }
        
        int[] res = new int[interset.size()];
        int i = 0;
        for (int num : interset) {
            res[i++] = num;
        }
        
        return res;
    }
}