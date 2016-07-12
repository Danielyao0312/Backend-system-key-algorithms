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
//     		f[i] = Integer.MAX_VALUE;
//     		for (int j = 0; j < i; j++) {
//     			if (isPalindrome(sarray, j+1, i)) {
//     				f[i] = Math.min(f[i], f[j] + 1);
//     			}
//     		}
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
    
    
// 九章 solution:  O(n2) 先计算并存储了 isPalindrome 的结果，每次使用的时候直接调用，isPalindrome[i][j] 从 O(n) 变为了 O(1)
    private boolean isPalindrome(String s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    private boolean[][] getIsPalindrome(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }

        for (int length = 2; length < s.length(); length++) {
            for (int start = 0; start + length < s.length(); start++) {
                isPalindrome[start][start + length]
                    = isPalindrome[start + 1][start + length - 1] && s.charAt(start) == s.charAt(start + length);
            }
        }

        return isPalindrome;
    }

    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        // preparation
        boolean[][] isPalindrome = getIsPalindrome(s);
        
        // initialize
        int[] f = new int[s.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            f[i] = i - 1;
        }
        
        // main
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (isPalindrome[j][i - 1]) {
                    f[i] = Math.min(f[i], f[j] + 1);
                }
            }
        }

        return f[s.length()];
    }

}