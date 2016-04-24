public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //merge nums2 into nums1, from rear to front, start = nums1.length - 1, insert into nums1
        if(nums1.length == 0 || nums2.length == 0) return;
        
        //initial the pointers
        int i = m - 1;
        int j = n - 1;
        int k = nums1.length - 1;
        
        while(i >= 0 && j >= 0) {
            if(nums1[i] >= nums2[j]){
                nums1[k] = nums1[i];
                i--;
            }else if(nums1[i] < nums2[j]){
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        if(i < 0 && j >= 0){
            while(j >= 0){
                nums1[k] = nums2[j];
                j--;
                k--;
            }
        }
        if(i >= 0 && j < 0){
            while(i >= 0){
                nums1[k] = nums1[i];
                i--;
                k--;
            }
        }
    }
}