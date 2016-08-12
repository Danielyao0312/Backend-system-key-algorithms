/*
brute force: find all substrings (n^2), 

*/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] exist = new boolean[256]; // ASCII
        int start = 0, maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            while (exist[s.charAt(i)])
                exist[s.charAt(start++)] = false;
            exist[s.charAt(i)] = true;
            maxLen = Math.max(i - start + 1, maxLen);
        }
        return maxLen;
    }
}