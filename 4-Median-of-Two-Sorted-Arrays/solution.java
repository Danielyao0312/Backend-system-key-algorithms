public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int len = A.length + B.length;
        if (len % 2 == 0) {
            return 1.0 * (findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)) / 2;
        } else {
            return findKth(A, 0, B, 0, len / 2 + 1);
        }
    }
    
   private double findKth(int[] nums1, int s1, int[] nums2, int s2, int k) {
        int m = nums1.length - s1;  // length of nums1
        int n = nums2.length - s2;  // length of nums2
        
        if (m > n) {
            return findKth(nums2, s2, nums1, s1, k);
        }
        
        if (m <= 0) {
            return nums2[s2 + k - 1];
        }
        if (n <= 0) {
            return nums1[s1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[s1], nums2[s2]);
        }
        
        int mid = k / 2 - 1;
        int nums1Key = s1 + mid < nums1.length ? 
                            nums1[s1 + mid] : Integer.MAX_VALUE;
        
        int nums2Key = s2 + mid < nums2.length ? 
                            nums2[s2 + mid] : Integer.MAX_VALUE;
        
        if (nums1Key < nums2Key) {
            return findKth(nums1, s1 + k / 2, nums2, s2, k - k / 2);
        } else {
            return findKth(nums1, s1, nums2, s2 + k / 2, k - k / 2);
        }
    }
}