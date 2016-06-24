public class Solution {
/*
九章上课讲题，找 median 就是在合并后的数组C里，找第(m + n) / 2 个数字， 先考虑高阶问题: 找第 k 个数字，因为题目提示要用 O(logN) 解法， 因此想到二分，二分的关键就是如何扔掉一半，因此考虑，每次取出 nums1 和 nums2的第 k/2个 元素，谁小的话，就证明，另外一个还没有出列放入C 中，因此，就把前 k / 2个元素给扔掉，从剩下的 k - k /2 中寻找即可

*/    
    
    public double findMedianSortedArrays(int A[], int B[]) {
        int len = A.length + B.length;
        if (len % 2 == 1) {
            return findKth(A, 0, B, 0, len / 2 + 1);
        }
        return (
            findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)
        ) / 2.0;
    }

    // find kth number of two sorted array
    public static int findKth(int[] A, int A_start,
                              int[] B, int B_start,
                              int k){		
		if (A_start >= A.length) {
			return B[B_start + k - 1];
		}
		if (B_start >= B.length) {
			return A[A_start + k - 1];
		}

		if (k == 1) {
			return Math.min(A[A_start], B[B_start]);
		}
		
		int A_key = A_start + k / 2 - 1 < A.length
		            ? A[A_start + k / 2 - 1]
		            : Integer.MAX_VALUE;
		int B_key = B_start + k / 2 - 1 < B.length
		            ? B[B_start + k / 2 - 1]
		            : Integer.MAX_VALUE; 
		
		if (A_key < B_key) {
			return findKth(A, A_start + k / 2, B, B_start, k - k / 2);
		} else {
			return findKth(A, A_start, B, B_start + k / 2, k - k / 2);
		}
	}
}