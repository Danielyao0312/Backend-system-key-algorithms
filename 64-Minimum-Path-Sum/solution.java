public class Solution {
    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     * 
     * state: f(i, j) = minSum when walk to (i, j)
     * function: f(i, j) = min{ f(i - 1,j), f(i, j-1) } + grid(i, j)
     * initial: f(0, j) = 从0到 j sum 起来， f(i, 0) 同理
     * answer : f(m - 1, n - 1)
     * 
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] sum = new int[m][n];
        sum[0][0] = grid[0][0];
        
        //initial:
        for (int i = 1; i < m; i++) {
            sum[i][0] = sum[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            sum[0][i] = sum[0][i - 1] + grid[0][i];
        }
        
        //function:
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                sum[i][j] = Math.min(sum[i - 1][j], sum[i][j - 1]) + grid[i][j];
            }
        }
        
        //answer:
        return sum[m - 1][n - 1];
    }
}
