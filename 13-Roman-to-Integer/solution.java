/*
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
*/

public class Solution {
	// XIV: if find a char that is great than the char before, distract the smaller one twice. eg. XIV;
	//general : add them together
	// DIX

	public int romanToInt(String s) {
		if (s == null || s.length() == 0)	return 0;

		int res = 0;

		for (int i = 0; i < s.length() - 1; i++) {
			int curNum = romanCharToInt(s.charAt(i));
			int postNum = romanCharToInt(s.charAt(i + 1));

			if (curNum < postNum) {
				res -= curNum;
			} else {
				res += curNum;
			}
		}

		res += romanCharToInt(s.charAt(s.length() - 1));
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