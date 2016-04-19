public class Solution {
    public int search(int[] A, int target) {
        //rotated array can be seperated into two segment
        
        if(A.length == 0 || A == null) return -1;
        
        int start = 0;
        int end = A.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start)/2;
            if(target == A[mid]) return mid;

            if(A[mid] >= A[start]){
                if(A[start] <= target && target <= A[mid]){
                    end = mid;
                }else{
                    start = mid;
                }
            }else{
                if (A[mid] <= target && target <= A[end]) {
                    start = mid;
                }else{
                    end = mid;
                }

            }

        }

        if(A[start] == target){
            return start;
        }
        else if(A[end] == target){
            return end;
        }
        else return -1;
    }
}