class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
     
    /*
    3 colors:
    red : 0
    white: 1
    blue: 2
    sort this array
    
    do a quick sort -> O(nlogn) => bad
    
    2 pass:
    1. count nums of 0, 1, 2   1pass
    2. put back to the nums,  1 pass
    O(n)
    
    1 pass:
    two pointers (actually 3 pointers):
    1. use curr to tarverse the nums:
        1. arr[cur] == 0 : move to red, cur++, red++
        2. arr[cur] == 1:  cur++
        3. arr[cur] == 2:  move to blue, blue--;
    
    */ 
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int red = 0;
        int blue = nums.length - 1;
        int cur = 0;
        
        while (cur <= blue) {  // 出错点！！！ cur <= blue
            if (nums[cur] == 0) {
                swap(nums, red, cur);
                red ++;
                cur ++;
            } else if (nums[cur] == 1) {
                cur ++;
            } else { // nums[cur] == 2
                swap(nums, blue, cur);
                blue --;
            }
        }
        
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}