public class Solution {
    
    private int[] nums;
    private int[] original;

    public Solution(int[] nums) {
        this.nums = nums;
        this.original = nums.clone();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random rand = new Random();
        
        int size = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int pos = rand.nextInt(size);
            swap(nums, i, pos);
        }
        return nums;
    }
    
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    } 
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */