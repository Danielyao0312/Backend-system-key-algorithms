public class Solution {
    // solution 1:
    public String reverseWords(String s) {
        
        s = s.trim();
        String[] arr = s.split("[ ]+");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]);
            sb.append(" ");
        }
        
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}