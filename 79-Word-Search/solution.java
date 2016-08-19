/*
dfs 暴力搜索4个方向，维护一个 visited 数组，去判断该元素是否已经被搜索过，若被搜索过，则返回 false

dfs 做 backtracking 时，注意递归的出口：
1. 不在 board 边界范围内，返回 false
2. 被访问过，返回 false


*/

public class Solution {
    
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {  // 以board中 所有的可能的节点为起点，去 dfs 的找
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, visited, i, j, 0)) {
                    return true;
                }
            }
        }    
        
        return false;
    }
    
    private boolean dfs(char[][] board, String word, boolean[][] visited, int i, int j, int index) {
        if (index == word.length()) {   // match
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {  // out of bound
            return false;
        }
        if (visited[i][j]) {  // visited
            return false;
        }
        if (board[i][j] != word.charAt(index)) {   // stop if not match
            return false;        
        }
        
        visited[i][j] = true;
        boolean match = dfs(board, word, visited, i + 1, j, index + 1) 
                        || dfs(board, word, visited, i, j + 1, index + 1) 
                        || dfs(board, word, visited, i - 1, j, index + 1) 
                        || dfs(board, word, visited, i, j - 1, index + 1);
        
        visited[i][j] = false;
        
        return match;
    }
    
    
    
}