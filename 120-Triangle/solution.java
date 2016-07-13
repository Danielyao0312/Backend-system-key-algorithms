public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
     
    // dfs solution
    // private static int best = Integer.MAX_VALUE;
    
    // public int minimumTotal(int[][] triangle) {
    //     int n = triangle.length;
    //     traverse(0, 0, 0, n, triangle);
    //     return best;
    // }
    
    // private void traverse(int x, int y, int sum, int n, int[][] A) {
    //     if(x == n) {
    //         if(sum < best) {
    //             best = sum;
    //         }
    //         return;
    //     }
        
    //     traverse(x + 1, y, sum + A[x][y], n, A);
    //     traverse(x + 1, y + 1, sum + A[x][y], n, A);
    // }
    
    /*
    state: f(i, j) 表示走到 i, j 的最小 sum
    
    function: f(i, j) = min {f(i - 1,j), f(i - 1, j - 1) } + A[i][j];
    
    initial: f(i, 0) = sum(0 ~ i), f(0, i) = triangle(0, 0)
    
    answer: min of last row : f[m - 1][]
    
    */
    
    public int minimumTotal(List<List<Integer>> tri) {
        // corner cases:
        if (tri == null || tri.size() == 0 || tri.get(0).size() == 0) {
            return -1;
        }
        
        int m = tri.size();
        int[][] sum = new int[m][m];
        sum[0][0] = tri.get(0).get(0);
        
        //initial:
        for (int i = 1; i < m; i++) {
            sum[i][0] = sum[i - 1][0] + tri.get(i).get(0);
            sum[i][i] = sum[i - 1][i - 1] + tri.get(i).get(i);
        }

        
        //function:
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < i; j++) {
                sum[i][j] = Math.min(sum[i - 1][j], sum[i - 1][j - 1]) + tri.get(i).get(j);
            }
        }
        
        //answer:
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            ans = Math.min(ans, sum[m - 1][i]);
        }
        
        return ans;
    }
}








