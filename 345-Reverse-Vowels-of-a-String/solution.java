public class Solution {
    public String reverseVowels(String s) {
        
        
        char[] arr = s.toCharArray();
        
        int i = 0, j = arr.length - 1;
        
        /*
        1. 左边右边都是元音 -> 交换，并且罗指针
        2. 左边是元音，右边不是， 右边往左罗
        3. 右边是，左边不是，左边挪
        4. 如果都不是元音，一起挪
        */
        while (i < j) {
            char left = arr[i];
            char right = arr[j];
            
            if (isVowel(left) && isVowel(right)) {
                swap(arr, i, j);
                i ++;
                j --;
            } else if (isVowel(left)) { // 
                j --;
            } else{ //左边不是元音，右边无所谓
                i ++;
            }
        }
        return new String(arr);
    }
    
    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}