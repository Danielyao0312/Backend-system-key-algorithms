public class Solution {
    public int addDigits(int num) {
        while (num >= 10) {
            num = sumOfDigits(num);
        }
        return num;
    }
    
    private int sumOfDigits(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }
}