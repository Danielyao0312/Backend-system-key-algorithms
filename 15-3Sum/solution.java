public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        return threeSum(nums, 0);
    }
    public List<List<Integer>> threeSum(int[] arr, int target) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(arr == null || arr.length == 0) {
            return result;
        }
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if(i != 0 && num == arr[i-1]) continue;
            int left = i+1;
            int right = arr.length - 1;
            while(left < right) {
                int sum = num + arr[left] + arr[right];
                if(sum == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(num);
                    list.add(arr[left]);
                    list.add(arr[right]);
                    result.add(list);
                    left ++;
                    right --;
                    while(left < right && arr[left] == arr[left-1]) left++;
                    while(left < right && arr[right] == arr[right+1]) right--;
                } else if(sum < target) {
                    left ++;
                } else {
                    right --;
                }
            }
        }

        return result;
    }
}