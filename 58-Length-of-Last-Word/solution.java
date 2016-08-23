public class Solution {
    // public int lengthOfLastWord(String s) {
    //     if (s == null || s.length() == 0) {
    //         return 0;
    //     }
        
    //     int start = 0, end = s.length();
        
    //     while (end - 1 >= 0 && s.charAt(end - 1) == ' ') {
    //         end --;
    //     }
        
    //     for (int i = 0; i < end; i++) {
    //         if (s.charAt(i) == ' ') {
    //             start = i + 1;
    //         }
    //     }
    //     return end - start;
    // }
    
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int index = s.lastIndexOf(' ') + 1;
        return s.length() - index;
        
    }
}