class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        lis = []
        res = []
        nums.sort()
        if nums is None or len(nums) == 0:
            return res;
        self.helper(res, lis, nums, 0)
        return res
        
    def helper(self, res, lis, nums, pos):
        res.append(list(lis))
        
        for i in xrange(pos, len(nums)):
            lis.append(nums[i])
            self.helper(res, lis, nums, pos + 1)
            lis.pop()
    
    
            