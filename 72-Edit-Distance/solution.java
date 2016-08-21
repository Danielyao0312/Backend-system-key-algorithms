/*
state:  word1的前 i 个字符，转换成 word2的前 j 个字符，最少的步数
function: 1. A[i] == B[j]:
            f(i,j) = min(f(i - 1, j) + 1,  f(i, j - 1) + 1, f(i - 1, j - 1);
        2. A(i) != B(j) :
            f(i,j) = min(f(i - 1, j) + 1,  f(i, j - 1) + 1, f(i - 1, j - 1) + 1);

initial: f[i][0] = i,  f[0][j] = j

answer: f[m][n]

*/

public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        int[][] dp = new int[m + 1][n + 1];
        
        //initial
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1) ) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min( Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1), dp[i-1][j-1] + 1);
                }
            }
        }
        
        return dp[m][n];
    }
}