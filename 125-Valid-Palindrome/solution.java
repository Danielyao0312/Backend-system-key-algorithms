public class Solution {

        // solution 1
    //  public boolean isPalindrome(String s) {
    //     if (s.isEmpty()) {
    //         return true;
    //     }
    //     s = s.toLowerCase();
    //     int head = 0, tail = s.length() - 1;
    //     char cHead, cTail;
        
    //     while(head <= tail) {
    //         cHead = s.charAt(head);
    //         cTail = s.charAt(tail);
            
    //         if (!Character.isLetterOrDigit(cHead)) {
    //             head++;
    //         }
    //         else if(!Character.isLetterOrDigit(cTail)) {
    //             tail--;
    //         } 
    //         else {
    //             if (cHead != cTail) {
    //                 return false;
    //             }
                
    //             head++;
    //             tail--;
    //         }
    //     }

    //     return true;
    // }
    
    // solution 2
    public boolean isPalindrome(String s) {
        if (s.length() == 0 || s == null) {
            return true;
        }
        
        s = s.toLowerCase();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) { 
                j--;
            }
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++; 
            j--;
        }
        return true;
        
    }
    
    
}