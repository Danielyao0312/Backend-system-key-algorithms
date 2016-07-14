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