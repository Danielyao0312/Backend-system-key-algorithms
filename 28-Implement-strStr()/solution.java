public class Solution {
    public int strStr(String source, String target) {
        if(source == null || target == null) return -1;
        int slen = source.length();
        int tlen = target.length();
        if(tlen > slen){
            return -1;
        }
        if(tlen == 0){
            return 0;
        }
        
        int i = 0, j = 0;
        for(i = 0; i <= slen - tlen; i++) {
            if(source.charAt(i) == target.charAt(0)){
                for(j = 0; j < tlen; j++){
                    if(source.charAt(i+j) != target.charAt(j)){
                        break;
                    }
                }
                if(j == tlen){
                    return i;
                }
            }
        }
        return -1;
    }
}