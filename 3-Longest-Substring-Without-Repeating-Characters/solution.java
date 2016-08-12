/*
brute force: find all substrings (n^2), 

pwwkesbwp :  6 kesbwp


*/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[256]; // map from character's ASCII to its last occured index
        Arrays.fill(map, -1);
        
        int slow = 0;
        int fast = 0;
        int ans = 0;
        for (fast = 0; fast < s.length(); fast++) {
            int ch = s.charAt(fast);
            while (map[ch] != -1 && slow < fast) { // 当 ch 已经出现过，并且 slow < fast 
                map[s.charAt(slow)] = -1; // slow 到 fast的之间的字符全部设置为 没出现过
                slow ++;
            }
            map[ch] = 1;
            ans = Math.max(ans, fast-slow + 1);
        }
        
        return ans;
    }
}