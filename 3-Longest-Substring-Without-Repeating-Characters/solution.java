/*
brute force: find all substrings (n^2), 

pwwkesbwp :  6 kesbwp

*/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[256];
        Arrays.fill(map, -1);
        
        int j = 0; // fast pointer
        int i = 0; // slow pointer
        int ans = 0;
        
        for (i = 0; i < s.length(); i++) {
            
            while (j < s.length() && map[s.charAt(j)] == -1) {  // 无重复的时候，把 j 往前挪动,  -1表示未出现过
                map[s.charAt(j)] = 0; // 把 j 位设置为重复，0表示出现过
                ans = Math.max(ans, j - i + 1);
                j ++;
            }  
            
            map[s.charAt(i)] = -1; // i 位在更新回未出现过
        }
        
        return ans;
    }
}