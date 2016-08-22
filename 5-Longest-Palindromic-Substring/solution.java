/*
1. brute force: find all substring: O(n2), check if each is palindrome, and get the longest
    totally: O(n3)
    
2. 求最大，又是一维 sequence，所以考虑是否为 dp 问题

第二种方法“是对于每个子串的中心（可以是一个字符，或者是两个字符的间隙，比如串abc,中心可以是a,b,c,或者是ab的间隙，bc的间隙，例如aba是回文，abba也是回文，这两种情况要分情况考虑）往两边同时进 行扫描，直到不是回文串为止。假设字符串的长度为n,那么中心的个数为2*n-1(字符作为中心有n个，间隙有n-1个）。对于每个中心往两边扫描的复杂 度为O(n),所以时间复杂度为O((2*n-1)*n)=O(n^2),空间复杂度为O(1)。

*/
public class Solution {
    public String longestPalindrome(String s) {
        // corner cases:
        if (s == null || s.length() == 0 || s.length() == 1) {
            return s;
        }
        
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            String temp = helper(s, i, i);
            
            if (temp.length() > longest.length()) {
                longest = temp;
            }
        }
        
        for (int i = 0; i < s.length() - 1; i++) {
            String temp = helper(s, i, i + 1);
            if (temp.length() > longest.length()) {
                longest = temp;
            }
        }
        
        return longest;
    }
     
     
     // Given a center, either one letter or two letter, 
     // Find longest palindrome
    private String helper(String str, int begin, int end) {
        while (begin >= 0 && end < str.length() && str.charAt(begin) == str.charAt(end) ) {
            begin --;
            end ++;
        }
        return str.substring(begin + 1, end);
    }
}