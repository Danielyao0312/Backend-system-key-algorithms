public class Solution {
    /**
     * @param s a string
     * @return an integer
     * 时间复杂度: O(n3)： 两重循环 加 回文判断
     */
//     public int minCut(String s) {
//     	char[] sarray = s.toCharArray();
//     	int n = s.length();
//     	int[] f = new int[n + 1];

//     	//initial:
//     	f[0] = -1;

//     	//function:
//     	for (int i = 1; i < n + 1; i++) {
//     		int min = Integer.MAX_VALUE;
//     		for (int j = 0; j < i; j++) {
//     			if (isPalindrome(sarray, j+1, i)) {
//     				min = Math.min(min, f[j]);
//     			}
//     		}
//     		f[i] = min + 1;
//     	}
//     	//answer:
//     	return f[n];
//     }

// // 注意由于f[] 的长度为 n + 1
// // 因此下标对应发生错位
// // 在 f[] 中的 i, 和 j 对应的字符为 chararray 中的 i - 1 和 j - 1
//     private boolean isPalindrome(char[] arr, int i, int j) {
//         i = i - 1;
//         j = j - 1;
//     	while (i < j) {
//     		if (arr[i] == arr[j]) {
//     			i++;
//     			j--;
//     		} else {
//     			return false;
//     		}
//     	}
//     	return true;
//     }
    
    
    public int minCut(String s) {
        int n = s.length();
        boolean[][] tab = new boolean[n][n];
        int[] min = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            min[i] = n - i - 1;
            for (int j = i; j < n; j++) {
                tab[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || tab[i + 1][j - 1]);
                if (tab[i][j]) min[i] = Math.min(min[i], j + 1 < n ? (1 + min[j + 1]) : 0);
            }
        }
        return min[0];
    }

}