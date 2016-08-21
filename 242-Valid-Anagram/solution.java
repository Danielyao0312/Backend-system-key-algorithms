// hashmap 统计两个串的频率即可
//一遍 bug free

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int i : count) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}