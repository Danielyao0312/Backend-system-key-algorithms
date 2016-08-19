public class Solution {
    
/*
Power of two must be 100...000 (one follows by all zeros).
*/    
    
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        while (n > 0) {
            if (n != 1 && (n & 1) != 0) return false;   // stop if any bit after 1 is not 0
            n >>= 1;
        }
        return true;
    }
    
// solution 2:

    // public boolean isPowerOfTwo(int n) {
    //     if (n <= 0) {
    //         return false;
    //     }
    //     return (n & n -1) == 0;
    // }
    
    
}