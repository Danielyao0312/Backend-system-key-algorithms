public class Solution {
    
    /*
       这道题运用位运算的异或。异或是相同为0，不同为1。所以对所有数进行异或，得出的那个数就是single number。初始时先让一个数与0异或，然后再对剩下读数挨个进行异或。
        这里运用到异或的性质：对于任何数x，都有x^x=0，x^0=x
    */
    
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i : nums) {
            res ^= i;
        }
        return res;
    }
}