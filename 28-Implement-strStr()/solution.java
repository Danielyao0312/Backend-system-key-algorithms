public class Solution {
    public int strStr(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }
        int slen = source.length();
        int tlen = target.length();
        
        if (slen < tlen)    return -1;
        if (tlen == 0)      return 0;
        
        int i, j;
        for (i = 0; i <= slen - tlen; i++) {
            for (j = 0; j < tlen; j++) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
            }
            if (j == tlen) {
                return i;
            }
        }
        return -1;
        
    }
}