public class Solution {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
     
    /*
    1. 求出每项对应的前 n 项乘积
    2. product (i ~ j) = T(j) / T(i - 1),  i, j 变动
    3. 枚举所有的 j, 找出之前乘积最小的，作为候选的 product, 挑出最大的就可
    错！因为分正负数！
    
    正确答案：
        
    1-d DP: Time ~ O(N), Space ~ O(1) 
    因为负数的存在，需要同时记录largest product和smallest product。
    Let f(i) be the largest product of the subarray ending at A[i].
    Let g(i) be the smallest product of the subarray ending at A[i].
    
    f(i) = max{f(i - 1) * A[i], A[i], g(i - 1) * A[i]}
    g(i) = min{f(i - 1) * A[i], A[i], g(i - 1) * A[i]}
    
    Use maxProd and minProd to store f(i) and g(i) at each i, respectively.
    Use max and min to store the largest f(i) and the smallest g(i), respectively.
    
    */ 
    
    public int maxProduct(int[] A) {
        int maxProd = 1, 
            minProd = 1, 
            max = Integer.MIN_VALUE, 
            min = Integer.MAX_VALUE;
        
        for (int i = 0; i < A.length; i++) {
            int temp = maxProd;
            maxProd = Math.max(Math.max(maxProd * A[i], A[i]), minProd * A[i]);
            minProd = Math.min(Math.min(minProd * A[i], A[i]), temp * A[i]);
            max = Math.max(maxProd, max);
            // min = Math.min(minProd, min);
        }
        return max;
    }
    


}