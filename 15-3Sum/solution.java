/**结题报告：
 * a + b + c = sum -> a + b = sum - c, 其中 a, b,c 为变量，sum 在本题中等于0, 所以,先排序 arr, 再遍历数组，每个A[i] 当做 c ,问题转化为2 sum, target = sum - c,  然后用双指针法，往中间夹取，有重复，则继续挪动指针
 * 
 * 3 Sum是two Sum的变种，可以利用two sum的二分查找法来解决问题。
 本题比two sum增加的问题有：解决duplicate问题，3个数相加返回数值而非index。
 首先，对数组进行排序。
 然后，从0位置开始到倒数第三个位置（num.length - 2)，进行遍历，假定num[i]就是3sum中得第一个加数，然后从i+1的位置开始，进行2sum的运算。
 当找到一个3sum==0的情况时，判断是否在结果hashset中出现过，没有则添加。(利用hashset的value唯一性）
 因为结果不唯一，此时不能停止，继续搜索，low和high指针同时挪动。
 
 * 
 */ 
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        //corner case
        if(nums == null || nums.length < 3) return result;
        
        //sort array
        Arrays.sort(nums);
        
        // a + b + c = 0 => a + b = -c, so let tar = -c for all elements in nums, 
        // then find a and b that a + b = - c => reduced to 2-sum problem
        for(int i = 0; i < nums.length - 2; i ++) {
            if( i==0 || nums[i] != nums[i-1]) {
                int tar = nums[i] * (-1);
                int j = i + 1; //  bugs here;
                int k = nums.length - 1;
                
                //traverse all elements left except for nums[i], find a + b = tar
                // if nums[j] + nums[k] > tar, move k to left,
                // if nums[j] + nums[k] < tar, move j to right,
                // if i + j = tar, sort i, j, k value, add to result;
                
                while(j < k){
                    if(nums[j] + nums[k] > tar) {
                        k--;
                    }else if(nums[j] + nums[k] < tar){
                        j++;
                    }else{
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        
                        result.add(list);
                        
                        j++;
                        k--;
                        
                        while(j<k && nums[j] == nums[j-1])//remove dupicate
                            j++;
                        while(j<k && nums[k] == nums[k +1])//remove dupicate
                            k --;
                    }
                }
            }
        }
        return result;
        
    }
}