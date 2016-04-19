public class Solution {
    public int search(int[] A, int target) {
        //rotated array can be seperated into two segment
        
        if(A.length == 0 || A == null) return -1;
        
        int start = 0;
        int end = A.length - 1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(target == A[mid]) return mid;

            if(A[mid] >= A[start]){
                if(A[start] <= target && target <= A[mid]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }else{
                if (A[mid] <= target && target <= A[end]) {
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }

            }
        }
        
        return -1;
    }
}