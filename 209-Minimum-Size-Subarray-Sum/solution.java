public class Solution {
    public static int minSubArrayLen(int s, int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int minLen = Integer.MAX_VALUE;
        int j = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            while (j < arr.length && sum < s) {
                sum += arr[j];
                j++;
            }
            if (sum >= s) {
                minLen = Math.min(minLen, j - i);
            }
            sum -= arr[i];
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}