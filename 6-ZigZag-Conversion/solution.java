public class Solution {
    /*
    无聊题，面试几乎不会考
    
    */
    
   public String convert(String s, int nRows) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        int length = s.length();
        if (length <= nRows || nRows == 1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();

        int step = 2 * (nRows - 1);
        int count = 0;

        for (int i = 0; i < nRows; i++){
            int interval = step - 2 * i;

            for (int j = i; j < length; j += step){
                   sb.append(s.charAt(j));
                count++;
                if (interval > 0 && interval < step 
                    && j + interval < length 
                    && count <  length) {
                    sb.append(s.charAt(j + interval));
                    count++;
                }
            }
        }
        return sb.toString();
    }

}