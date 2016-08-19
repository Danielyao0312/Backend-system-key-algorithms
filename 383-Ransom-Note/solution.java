/*
1. hash统计magazine各个字母的数量，

*/

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
    	if (magazine == null || ransomNote == null) {
    		return false;
    	}
    	if (ransomNote.length() > magazine.length()) {
    		return false;
    	}

        int[] count = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
        	count[magazine.charAt(i) - 'a']++;
        }		

        for (int i = 0; i < ransomNote.length(); i++) {
        	if (--count[ransomNote.charAt(i) - 'a'] < 0) { // --在前， 先减再判断; --在后， 先判断，在减去
        		return false;
        	}
        }			
        return true;
    }
}