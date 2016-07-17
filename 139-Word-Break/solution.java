/*
state: 前 i 个字符能否被完美切割
function : f[i] = OR{ f[j] && j + 1 ~ i 为一个单词 }
initial: f[0] = true
answer: f[n]

*/

public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        //corner case:
        if (s == null || s.length() == 0) {
            return true;
        }
        
        //initial:
        int n = s.length();
        int maxLen = 0;
        for (String i : wordDict) {
            maxLen = Math.max(maxLen, i.length());
        }
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        
        //func:
        for (int i = 1; i < n + 1; i++) {
            for (int j = i >= maxLen ? i - maxLen : 0; j < i; j++) {
                String sub = s.substring(j, i);
                if (dp[j] && wordDict.contains(sub)) {
                    dp[i] = true;
                    break;
                } 
            }
        }
        
        //answer:
        return dp[n];
        
    }
}