/*
state: f[i] ：到达i所需要的最小步数
function: 对于 i 之前的所有 j， 满足 j + nums[j] >= i 的 j , 取一个最小的 + 1
        f[i] = min( for all j that j + nums[j] >= i) + 1 

initial: f[0] = 0
answer: f[n - 1]

*/



public class Solution {
    
// this is the right solution!!  O(n2) DP
    // public int jump(int[] nums) {
    //     int n = nums.length;
    //     int[] f = new int[n];
        
    //     f[0] = 0;
    //     for (int i = 1; i < n; i++) {
    //         int min = Integer.MAX_VALUE;
    //         for (int j = 0; j < i; j++) {
    //             if( j + nums[j] >= i) {
    //                 min = Math.min(min, f[j]);
    //             }
    //         }
    //         f[i] = min + 1;
    //     }
    //     return f[n - 1];
    // }
    
    public int jump(int[] A) {
        int jumps = 0;
        int prev = 0;   // the farthest index that has been reached
        int max = 0;    // the farthest index than can be reached
        for (int i = 0; i < A.length; i++) {
            if (i > prev) { // ready to jump
                if (max == prev)   return -1;   // unreachable
                prev = max;
                jumps++;
            }
            max = Math.max(max, i + A[i]);
        }
        return jumps;
    }
    
    
}