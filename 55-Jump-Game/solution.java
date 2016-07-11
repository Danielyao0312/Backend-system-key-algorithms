/*
state: f[i] 表示能否从起点跳到 i
function: f[i] = OR (f[j] && j 能够到 i)   对于所有小于 i 的点，只要有一个，他本身能被到达，并且从他能够到达 i 
initial : f[0] = true
answer : f[n - 1]
*/

public class Solution {
    // public boolean canJump(int[] nums) {
    //     int n = nums.length;
    //     boolean[] f = new boolean[n];
        
    //     f[0] = true;
        
    //     for (int i = 1; i < n; i ++) {
    //         for (int j = 0; j < i; j++) {
    //             if (f[j] && j + nums[j] >= i) {
    //                 f[i] = true;
    //                 break;
    //             }
    //         }
    //     }
    //     return f[n - 1];
    // }
    
    //greedy
    public boolean canJump(int[] A) {
               // think it as merging n intervals
        if (A == null || A.length == 0) {
            return false;
        }
        int farthest = A[0];
        for (int i = 1; i < A.length; i++) {
            if (i <= farthest && A[i] + i >= farthest) {
                farthest = A[i] + i;
            }
        }
        return farthest >= A.length - 1;

    }
}