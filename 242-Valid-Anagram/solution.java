public class Solution {
//     //solution 1: sort
//     public boolean isAnagram(String s, String t){
//         if(s.length() != t.length()) return false;
        
//         return sort(s).equals(sort(t));
//     }
    
//     private String sort(String s){
//         char[] ss = s.toCharArray();
//         Arrays.sort(ss);
//         return new String(ss);
//     }
    
    
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];
    
        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
    
        for(int x : count) {
            if(x != 0) return false;
        }
    
        return true;

    }
    
}