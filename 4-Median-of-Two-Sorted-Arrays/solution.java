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
        if (aStart >= A.length) {
            return B[bStart + k - 1];
        }
        if (bStart >= B.length) {
            return A[aStart + k - 1];
        }

        if (k == 1) {
            return Math.min(A[aStart], B[bStart]);
        }

        int mid = k / 2 - 1;

        if (A.length <= aStart + mid) {
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