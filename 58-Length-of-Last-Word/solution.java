public class Solution {
    // public int lengthOfLastWord(String s) {
    //     if (s == null || s.length() == 0) {
    //         return 0;
    //     }
        
    //     int start = 0, end = s.length() - 1;
        
    //     while (end >= 0 && s.charAt(end) == ' ') {
    //         end --;
    //     }
        
    //     end++; // end 指向最后一个单词的下一个位置
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