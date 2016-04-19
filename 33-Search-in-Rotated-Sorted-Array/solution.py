class Solution(object):
    def search(self, nums, target):

        s = 0
        e = len(nums)-1

        while s<=e:
            mid = (s+e)/2

            vmid = nums[mid]
            vs = nums[s]
            ve = nums[e]

            if vmid == target:
                return mid
            elif vs == target:
                return s
            elif ve == target:
                return e

            if ((target-vs) * (target - vmid) <= 0 and vs < vmid) or (vmid < ve and (target-ve) * (target - vmid) > 0):
                e = mid-1
            else:
                s = mid+1
        return -1