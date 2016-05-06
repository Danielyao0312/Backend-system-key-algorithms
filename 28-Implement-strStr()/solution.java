public class Solution {
    public int strStr(String source, String target) {
        //source string, target string, source = abinsticatoraaa, target = insticator, should return 2
        //corner cases:if target.length > source.length, return -1
        //if source is null or target is null return -1
        
        //corner cases:
        if(source == null || target == null) return -1;
        int slen = source.length();
        int tlen = target.length();
        if(tlen > slen){
            return -1;
        }
        if(tlen == 0){
            return 0;
        }
        
        for(int i = 0; i < slen; i++) {
            if(source.charAt())
        }
        
        
               
    }
}