public class Solution {
    public int reverse(int x) {
        int num = Math.abs(x);
        long result = 0;
        
        while(num > 0){
            result = result * 10 + num % 10;
            num /= 10;
        }
        if(result > Integer.MAX_VALUE){
            return 0;
        }
        
        return x > 0 ? (int)result : (int) -result;
    }
}