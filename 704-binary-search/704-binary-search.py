class Solution:
    def search(self, nums, target):
        index = bisect.bisect_left(nums, target)
        return index if index < len(nums) and nums[index] == target else -1