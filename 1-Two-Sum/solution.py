class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        res = []
        map = {}
        for i in xrange(len(nums)):
            if target - nums[i] in map:
                res.append(map[target - nums[i]])
                res.append(i)
                break
            else:
                map[nums[i]] = i
        return res