/*
1. sort arr
2. use two pointer: j, k   j go right , k go left,  find the triplet that addup to 0

remove dup:
1. arr[i] == arr[i - 1]
2. when sum == 0: 
    arr[j] == arr[j - 1]  j++
    arr[k] == arr[k + 1]  k--

*/

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    res.add(temp);
                    j ++;
                    k --;
                    while (j < k && nums[j] == nums[j - 1])     j ++;
                    while (j < k && nums[k] == nums[k + 1])     k --;
                } else if (sum < 0) {
                    j ++;
                } else {
                    k --;
                }
            }
        }
        
        return res;
    }
}