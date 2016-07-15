/*
每行每列都是严格递增的，所以看成在一个一维数组里面搜索，第 n 个数的位置是[n / column][n % column]


*/

public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int row = matrix.length;
        int column = matrix[0].length;
        int len = row * column;
        int start = 0, end = len - 1, mid = 0;

        
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            int num = matrix[mid / column][mid % column];
            if (num == target) {
                return true;
            } else if (num < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (matrix[start / column][start % column] == target) {
            return true;
        } else if (matrix[end / column][end % column] == target) {
            return true;
        } else {
            return false;
        }
    }
}