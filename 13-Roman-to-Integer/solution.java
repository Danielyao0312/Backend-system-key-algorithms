/*
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
*/

public class Solution {
	// XIV: if find a char that is great than the char before, distract the smaller one twice. eg. XIV;
	//general : add them together

	public int romanToInt(String s) {
		if (s == null || s.length() == 0)	return 0;

		int res = 0;
		res += romanCharToInt(s.charAt(0));

		for (int i = 1; i < s.length(); i++) {
			int curNum = romanCharToInt(s.charAt(i));
			int preNum = romanCharToInt(s.charAt(i - 1));

			if (curNum > preNum) {
				res += curNum - 2 * preNum;
			} else {
				res += curNum;
			}
		}
		return res;
	}

    private int romanCharToInt(char c){
        switch(c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
        
    }
}