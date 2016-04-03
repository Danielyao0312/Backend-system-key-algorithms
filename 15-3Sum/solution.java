public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        
        //corner cases
        if(nums.length == 0 || nums == null) return res;
        
        // sort the array
        Arrays.sort(nums);
        
        /**
         * iterate the array, for every num in the array, treat every num as a 'target', thus, 
         * 3 sum -> 2 sum problem, so, a + b + c = 0 => -a = b + c, given a, find b and c
         * in this case, I will use binary search to solve this problem
         */
        // int slow = 0;
        // int high = nums.length - 1;
        
            // a + b + c = 0 => b + c = -a => b + c = tar
            //find b + c = tar
            //traverse all elements left, find c = tar - b        
        for(int i = 0; i < nums.length; i++) {
            int tar = nums[i] * (-1);

            for(int j = i + 1; j < nums.length; j++){
                int b = nums[j];
                // int[] newArr = Arrays.copyOfRange(nums, j+1, nums.length);
                
                int[] newArr = nums;
                int c_index = find(tar - b, j+1 ,newArr);
                
                //if successfully find c, then store (-tar, b, c) into result
                if(c_index >= 0) {
                    List<Integer> subres = new ArrayList<Integer>();
                    subres.add(-tar);
                    subres.add(b);
                    subres.add(newArr[c_index]);
                    if(!set.contains(subres)){
                        res.add(subres);
                        set.add(subres);
                    }
                    
                }
            }
        }
        return res;
        
    }
    
    
    // this is binary search implementation
    private int find(int target, int start, int[] arr){
        if(arr == null || arr.length == 0) return -1;
        
        int end = arr.length - 1;
        int mid = 0;
        
        while(start <= end) {
            mid = start + (end - start) / 2;
            
            if(arr[mid] > target){
                end = mid - 1;    
            }else if(arr[mid] < target){
                start = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
    
}