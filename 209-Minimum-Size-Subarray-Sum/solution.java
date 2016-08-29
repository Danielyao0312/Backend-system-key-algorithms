/*

minLen = MAX_VALUE
two pointers:
1. i, j 
2. move j, calculate sum until sum >= s
3. update the minLen
4. sum -= nums[i],  move i forward

O(n)

corner case: 
*/

public class Solution {
    public int minSubArrayLen(int s, int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        
        int minLen = Integer.MAX_VALUE;
        int j = 0, sum = 0;
        
        for (int i = 0; i < arr.length; i++) {
            while (j < arr.length && sum < s) {
                sum += arr[j];
                j ++;
            }
            if (sum >= s) {
                minLen = Math.min(minLen, j - i);
            }
            sum -= arr[i];
        }
        
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}