public class Solution {
    public int threeSumClosest(int[] arr, int target) {
        int res = 0;
        int diff = Integer.MAX_VALUE;

        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int j = i + 1;
            int k = arr.length - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (Math.abs(sum - target) < diff) {
                    res = sum;
                    diff = Math.abs(sum - target);
                }
                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    k --;
                } else {
                    j ++;
                }
            }
        }
        
        return res;
    }
}