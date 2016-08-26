public class Solution {
    
    // 方法一：用 minHeap, 大小为 k, 遍历完成 heap 中就有最大的 k 个数，堆顶即为第 k 大！ 
    // time: O(nlogk), space: O(k)
    public static int findKthLargest(int[] nums, int k) {
        if (k == 0 || nums == null || nums.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        for (int i = 0; i < nums.length; i++) {
            if (minHeap.size() < k) {
                minHeap.add(nums[i]);
            }
            else if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }

        return minHeap.peek();
    }
}