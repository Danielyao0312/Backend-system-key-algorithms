


public class Solution{
	public int strStr(String str, String target) {
		int slen = str.length();
		int tlen = target.length();

		if(tlen > slen)		return -1;

		int j = 0;
		for(int i = 0; i < slen - tlen + 1; i++) {
			for(j = 0; j < tlen; j++) {
				if(target.charAt(j) != str.charAt(i + j))
					break;
			}
			if(j == tlen)	return i;
		}
		return -1;
	}	
}
