public class Solution {
    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     * 
     state: word1 的前 i 个字符 最少要转换几次 变成 word2 的前 j 个字符
     function: 
         1. when A[i] == B[j]
         f[i][j] = min(f(i - 1, j) + 1, f(i, j - 1) + 1, f(i - 1, j - 1))
         2. when A[i] != B[j]
         f[i][j] = min(f(i - 1, j) + 1, f(i, j - 1) + 1, f(i - 1, j - 1) + 1)
     
     initial: f[i][0] = i, f[0][j] = j
     answer: f[m][n]
     * 
     * 一遍 bug free!!!
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] f = new int[m + 1][n + 1];
        
        //initial
        for (int i = 0; i < m + 1; i++) {
            f[i][0] = i;
        }
        for (int i = 0; i < n + 1; i++) {
            f[0][i] = i;
        }
        
        //function:
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    int temp = Math.min(f[i - 1][j] + 1, f[i][j - 1] + 1);
                    f[i][j] = Math.min(temp, f[i - 1][j - 1]);
                } else {
                    int temp1 = Math.min(f[i - 1][j], f[i][j - 1]);
                    f[i][j] = Math.min(temp1, f[i - 1][j - 1]) + 1;
                }
            }
        }
        
        return f[m][n];
        
        
        
    }
}