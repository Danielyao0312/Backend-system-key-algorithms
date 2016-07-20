public class Solution {
    /**
    递归三要素:
    1. 定义
    2. 如何变到更小规模的问题
    3. 出口（极端小的情况返回什么，做什么事儿）
    */
    
    /*
    1. 把以1，2，3.....分别开头的结果加入 res中
    2. 出口，当结果数组长度为总长时
    */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        
        if (nums == null || nums.length == 0) {
            return res;
        }
        int[] visited = new int[nums.length];
        
        // 把[] 开头的所有排列，加入到 res 中
        helper(res, list, nums, visited);
        return res;
    }
    
    //定义：把 list 开头的所有排列，加入到 res 中
    private void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int[] visited) {
        // 出口:
        if (list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        
        // 把[1]开头 [2]开头  [3]开头的结果分别加入到 res 中
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            // if (list.contains(nums[i])) {
            //     continue;
            // }
            visited[i] = 1;
            list.add(nums[i]); // 把1加入到了[], 变成了[1]
            helper(res, list, nums, visited); // 把【1】 开头的，加入 res 中
            list.remove(list.size() - 1);
            visited[i] = 0;
        }
    }
}