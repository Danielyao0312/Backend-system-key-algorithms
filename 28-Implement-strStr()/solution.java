public class Solution {
    public int strStr(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }
        if (source.length() < target.length()) {
            return -1;
        }
        // if (source.length() == 0 && target.length() == 0) {
        //     return 0;
        if (target.length() == 0) {
            return 0;    
        }
        
        char[] ss = source.toCharArray();
        char[] tt = target.toCharArray();
        
        int i = 0, j = 0;
        for (i = 0; i < ss.length - tt.length + 1; i++) {
            if (ss[i] == tt[0]) {
                for (j = 0; j < tt.length; j++) {
                    if (ss[i + j] != tt[j]) {
                        break;
                    }
                }
                if (j == tt.length) {
                    return i;
                }
            }
        }
        return -1;
    }
}