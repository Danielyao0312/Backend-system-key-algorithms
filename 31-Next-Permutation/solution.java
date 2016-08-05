/*
这道题是给定一个数组和一个排列，求下一个排列。算法上其实没有什么特别的地方，主要的问题是经常不是一见到这个题就能马上理清思路。下面我们用一个例子来说明，比如排列是(2,3,6,5,4,1)，求下一个排列的基本步骤是这样：
1) 先从后往前找到第一个不是依次增长的数，记录下位置p。比如例子中的3，对应的位置是1;
2) 接下来分两种情况：
    (1) 如果上面的数字都是依次增长的，那么说明这是最后一个排列，下一个就是第一个，其实把所有数字反转过来即可(比如(6,5,4,3,2,1)下一个是(1,2,3,4,5,6));
    (2) 否则，如果p存在，就从后向前找，找到第一个比p大的数字，然后两个调换位置，比如例子中的4。调换位置后得到(2,4,6,5,3,1)。最后把p之后的所有数字倒序，比如例子中得到(2,4,1,3,5,6), 这个即是要求的下一个排列。
以上方法中，最坏情况需要扫描数组三次，所以时间复杂度是O(3*n)=O(n)，空间复杂度是O(1)。代码如下：

2,3,6,5,4,1
1. 找到3 
2. 找到4 （右边第一个比3大的）
3. 交换3, 4 => 2,4,6,5,3,1
4. reverse 4 的右边部分 => 2,4,1,3,5,6

*/

public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;  // 完成步骤1，找到 i 即为从右往左第一个下降的位置
        }
        
        if (i < 0) {
            reverse(nums, 0, nums.length - 1); // 全下降，直接 reverse
            return;
        } else {
            int j = nums.length - 1;
            while (j >= i && nums[j] <= nums[i]) {
                j --;
            }
            swap(nums, i, j);
            
            reverse(nums, i+1, nums.length - 1);
        }
        
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}