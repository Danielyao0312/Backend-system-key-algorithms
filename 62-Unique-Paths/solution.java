public class Solution {
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     * 
     * state: f(i,j) = how many unique ways to get to the position(i,j)?
     * function: f(i, j) = f(i - 1, j) + f(i, j -1)
     * initial: the first column and first row, f(i, 0) = 1 and f(0, j) = 1
     * answer : f(m - 1, n -1)
     */
    public int uniquePaths(int m, int n) {
        if(m == 0 || n == 0) {
            return 0;
        }
        
        
        int[][] sum = new int[m][n];
        
        // initial
        for (int i = 0; i < m; i++) {
            sum[i][0] = 1;
        }
        
        for (int i = 0; i < n; i++) {
            sum[0][i] = 1;
        }
        
        //function:
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1];
            }
        }
        
        return sum[m - 1][n - 1];
    }
}
