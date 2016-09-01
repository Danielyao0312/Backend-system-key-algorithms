public class Solution {
    public int[] twoSum(int[] arr, int target) {
        int[] res = new int[2];
        
        if (arr == null || arr.length < 2) {
            return res;
        }
        
        int i = 0;  //left
        int j = arr.length - 1;  //right
        while (i < j) {
            int sum = arr[i] + arr[j];
            if (sum == target) {
                res[0] = i + 1;
                res[1] = j + 1;
                return res;
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        
        return res;
    }
}