public class Solution {
    /**
     *@param num: A list of non negative integers
     *@return: A string
     */
     
    /*
     [3, 30, 34, 5, 9]  => 9534330
    
    a  3
    b  30
    
    a+b  330
    b+a  303
    
    (b+a).compareTo(a+b) < 0
    
    所以排序 a  b =>  3,30
    
    1. convert int[] => string[]
    2. sort the string[] based on comparator
    3. use stringbuilder => res
    
    */ 
    class myComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            return (b + a).compareTo(a + b);
            
            // if ((a + b).compareTo(b + a) > 0) {  // ab > ba
            //     return -1;
            // } else {
            //     return 1;
            // }
            
        }
    }
    
    
    public String largestNumber(int[] num) {
        
        // cornercase: if all of nums are 0
        // int index = 0;
        // while (index < num.length && num[index] == 0) {
        //     index ++;
        // }
        // if (index == num.length) {
        //     return "0";
        // }
        
        int index = 0;
        for (; index < num.length && num[index] == 0; index++);
        if (index == num.length) {
            return "0";
        }
        
        
        // convert to string
        String[] numStr = new String[num.length];
        for (int i = 0; i < num.length; i++) {
            numStr[i] = String.valueOf(num[i]);
        }
        // sort
        Arrays.sort(numStr, new myComparator());
        
        // concate string[]
        StringBuilder sb = new StringBuilder();
        for (String i : numStr) {
            sb.append(i);
        }
        return sb.toString();
        
    }
    
    
}

