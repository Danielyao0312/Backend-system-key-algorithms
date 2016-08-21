public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     * 
     * state: f[i] means how many ways to reach stage i.
     * function: f[i] = f[i - 1] + f[i - 2]
     * initial: f[0] = 1, f[1] = 1
     * answer: f[n]
     * 
     */
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        
        // int[] f = new int[n + 1];
        int[] f = new int[2];
        f[0] = 1;
        f[1] = 1;
        
        for (int i = 2; i < n + 1; i++) {
            f[i % 2] = f[(i - 1) % 2] + f[(i - 2) % 2];
        }
        
        return f[n % 2];
        
    }
}