public class Solution {
    public boolean isPalindrome(int x) {
        String str = Integer.toString(x);
        int i = 0, j = str.length() - 1;
        while (i < j) {
            char left = str.charAt(i);
            char right = str.charAt(j);
            
            if (left != right) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
