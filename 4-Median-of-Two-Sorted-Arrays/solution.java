public class Solution {
	public double findMedianSortedArrays(int[] A, int[] B) {
	    int k = A.length + B.length;
	    
	    if (k % 2 == 0) {
		    return	(1.0)*(kth(A, 0, B, 0, k/2) + kth(A, 0, B, 0, k/2 + 1)) / 2;    
	    } else {
	        return kth(A, 0, B, 0, k/2 + 1);
	    }
	    
	}
	
	// 重点理解！！！这一部分的代码，马帅版本
    public int kth(int[] nums1, int s1, int[] nums2, int s2, int k) {
        if (nums1.length - s1 > nums2.length - s2) {
            return kth(nums2, s2, nums1, s1, k);
        }
        
        if (nums1.length == s1) {
            return nums2[s2 + k - 1];
        }
        
        if (k == 1) {
            return Math.min(nums1[s1], nums2[s2]);
        }
        
        int a = Math.min(nums1.length - s1, k / 2);
        int b = k - a;
        
        if (nums1[s1 + a - 1] < nums2[s2 + b - 1]) {
            return kth(nums1, s1 + a, nums2, s2, k - a);
        } else if (nums1[s1 + a - 1] > nums2[s2 + b - 1]) {
            return kth(nums1, s1, nums2, s2 + b, k - b);
        } else {
            return nums1[s1 + a - 1];
        }
    }
	
}