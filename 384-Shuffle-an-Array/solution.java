public class Solution {
    
    private int[] nums;
    private int[] original;
    // private Random rand;

    public Solution(int[] nums) {
        this.original = nums;
        this.nums = nums.clone();
        // this.rand = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        // nums = original.clone();
        // return nums;
        return original;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random rand = new Random();
        int size = nums.length;
        
        for (int i = 0; i < size; i++) {
            int pos = rand.nextInt(size - i); //不太理解
            swap(nums, i, i + pos);  // ？？？？为什么是 i + pos?
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