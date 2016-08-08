public class Solution {
    // public String reverseString(String s) {
    //     if(s == null || s.length() == 0) return s;
        
    //     StringBuilder sb = new StringBuilder();
    //     for(int i = s.length() - 1; i >= 0 ; i--){
    //         char ss = s.charAt(i);
    //         sb.append(ss);
    //     }
        
    //     return sb.toString();
    // }
    
    public String reverseString(String str) {
        char[] arr = str.toCharArray();
        int i = 0, j = str.length() - 1;
        
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return new String(arr);
    }
}