public class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        
        if (digits[len - 1] == 9) {
            // 1. 123999 => 设置一个 carry = 0 
            int carry = 1;
            for (int i = len - 1; i >= 0; i--) {
                digits[i] += carry;
                
                if (digits[i] == 10) {
                    carry = 1;
                    digits[i] = 0;
                } else {
                    carry = 0;
                }
            }
            
            //1. 全部是99999 => 需要新开一个窗口 100000
            if (digits[0] == 0) {
                digits = new int[len + 1];
                digits[0] = 1;
            }
            return digits;
                            
        } else {
            digits[len - 1] ++;
            return digits;
        }
    }
}