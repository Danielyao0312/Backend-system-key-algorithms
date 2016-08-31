public class Solution {
    
    //version 1: loops
    // public int addDigits(int num) {
    //     while(num >= 10){
    //         num = sumOfDigits(num);
    //     }
    //     return num;
    // }
    
    // public int sumOfDigits(int num){
    //     int temp = 0;
    //     while(num > 0) {
    //         temp += num % 10;
    //         num = num / 10;
    //     }
    //     return temp;
    // }
    // version2
     public int addDigits(int num) {
         return 1 + (num - 1) % 9;
    }
    
    
}