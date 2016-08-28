public class Solution {
    
    public double findMedianSortedArrays(int A[], int B[]) {
        int len = A.length + B.length;
        if (len % 2 == 0) {
            return 1.0 * (findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)) / 2;
        } else {
            return findKth(A, 0, B, 0, len / 2 + 1);
        }
    }

    //find kth of two sorted list
    private double findKth(int[] A, int aStart, int[] B, int bStart, int k) {
        /*
        1. 比较 nums1[k/2] 和 nums2[k/2]的位置，谁小，就把谁的前一半给扔了！然后从剩下的里面去寻找
        
        重点: corner cases:
        1. nums1 为空，去 nums2里找
        2. nums2 为空，去 nums1里找
        3. k == 1，就比较前两个
        
        主程序：
        比较 nums1[k/2] 和 nums2[k/2]的位置，谁小，就把谁的前一半给扔了！然后从剩下的里面去寻找
        corner case:
        1. 若 nums1 不足 k / 2个，就去把 nums2 的前 k/2个给扔了!
        2. 若 nums2 不足 k / 2个，就去把 nums1 的前 k/2个给扔了!
        */
        
        
        if (aStart >= A.length) {  //a 数组没有了，从 b 里面找
            return B[bStart + k - 1];
        }
        if (bStart >= B.length) { // B 数组没有了，从 A 里面找
            return A[aStart + k - 1];
        }

        if (k == 1) {
            return Math.min(A[aStart], B[bStart]);
        }

        int mid = k / 2 - 1;

        if (A.length <= aStart + mid) {  // A[] 的元素个数不足 k / 2个时，直接扔掉 B 的前 k / 2个元素！
            return findKth(A, aStart, B, bStart + k / 2, k - k / 2);
        }
        else if (B.length <= bStart + mid) {
            return findKth(A, aStart + k / 2, B, bStart, k - k / 2);
        }
        else if (A[aStart + mid] < B[bStart + mid]) {
            return findKth(A, aStart + k / 2, B, bStart, k - k / 2);
        }
        else {  // A[aStart + mid] > B[bStart + mid])
            return findKth(A, aStart, B, bStart + k / 2, k - k / 2);
        }

    }

}