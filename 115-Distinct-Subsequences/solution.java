public class Solution {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     * 
     * state: f[i][j] 表示 s 的前 i 个配上 t 的前 j 个能有多少个？
     * function: 
     * 1. f[i][j] = f[i - 1][j - 1] + f[i - 1][j]    if A[i] == B[j]
     * 2. f[i][j] = f[i - 1][j]        if A[i] != B[j]
     * 
     * initial: f(i, 0) = 1, f(0, i) = 0
     * answer: f[m][n]
     */
    public int numDistinct(String S, String T) {
        if (S.length() < T.length()) {
            return 0;
        }
        int m = S.length();
        int n = T.length();
        
        int[][] f = new int[m + 1][n + 1];
        
        //initial:
        for (int i = 0; i < m + 1; i++) {
            f[i][0] = 1;
        }
        //不需要赋初值了，因为本身初始化的时候的默认值就为0
        // for (int i = 1; i < n + 1; i++) { //易错点，从1 开始，因为(0,0)为1
        //     f[0][i] = 0;
        // }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + f[i - 1][j];
                } 
                else {             // s[i] != s[j]
                    f[i][j] = f[i - 1][j];
                }
                
            }
        }
        
        return f[m][n];
        
    }
}