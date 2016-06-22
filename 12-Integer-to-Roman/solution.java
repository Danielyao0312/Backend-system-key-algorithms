/*
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
*/


public class Solution {
	/*
	思路：所有可能的最小单元: 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000
	单个的最小单元: 1, 5, 10, 50, 100, 500, 1000 
	*/

	//recursion:

    static final String[] symbol = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    static final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    //recursion 
//     private String fuckingAwesomeIntToRoman(int num, int start) {
//     	for (int i = 0; i < values.length; i++) {
//     		if (num >= values[i]) {
//     			return symbol[i] + fuckingAwesomeIntToRoman(num - values[i], 
//     				start == 0 ? 0 : start + 1);
//     		}
//     	}
// 		return "";    	
//     }
//     public String intToRoman(int num) {
//     	return fuckingAwesomeIntToRoman(num, 0);
//     }
    
// non- recursion:
    // num = 957 -> find 900 < 957, num = num -900 -> num = 57
    public String intToRoman(int num) {

    	StringBuilder sb = new StringBuilder();

    	for (int i = 0; i < values.length; i++) {
    		while (num >= values[i]) {
    			sb.append(symbol[i]);
    			num = num - values[i];
    		}
    	}

    	return sb.toString();
    }

}
