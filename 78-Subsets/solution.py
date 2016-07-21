class Solution(object):
    def subsets(self, nums):
        res = []
        self.dfs(sorted(nums), 0, [], res)
        return res
        
    def dfs(self, nums, index, path, res):
        res.append(path)
        for i in xrange(index, len(nums)):
            self.dfs(nums, i+1, path+[nums[i]], res)
        
    
    # def subsets(self, nums):
    #     """
    #     :type nums: List[int]
    #     :rtype: List[List[int]]
    #     """
    #     lis = []
    #     res = []
    #     nums.sort()
    #     if nums is None or len(nums) == 0:
    #         return res;
    #     self.helper(res, lis, nums, 0)
    #     return res
        
    # def helper(self, res, lis, nums, pos):
    #     aa = list(lis)
    #     res.append(aa)
        
    #     for i in xrange(pos, len(nums)):
    #         lis.append(nums[i])
    #         self.helper(res, lis, nums, pos + 1)
    #         lis.pop()
    
    
            