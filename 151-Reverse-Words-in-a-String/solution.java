public class Solution {
    // solution 1: 按空格切分
    public String reverseWords(String s) {
        
        String[] arr = s.split("[ ]+");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!arr[i].equals("")) {
                sb.append(arr[i]).append(" ");
            }
        }
        
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }
}