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
        s = s.toLowerCase();
        if (s.isEmpty()) return true;
        
        int low = 0;
        int high = s.length() - 1;
        int len = s.length();
       
        while(low < high){
            while (!isAlphaOrDigit(s.charAt(low)) && low < high){
                low ++;
            }
            while (!isAlphaOrDigit(s.charAt(high)) && low < high ){
                high --;
            }
            if(s.charAt(low) != s.charAt(high)){
                 return false;
            }
            low++;
            high--;
        }
        
        return true;
        
    }
    
    
    public boolean isAlphaOrDigit(char c){
        if( c >='a' && c <= 'z') return true;
        if( c >='A' && c <= 'Z') return true;
        if( c >='0' && c <= '9') return true;
        return false;
    }
    
    
}