class Solution:
    def findClosestNumber(self, nums: List[int]) -> int:
        nums = sorted(nums, key=lambda x:abs(x))
        return abs(nums[0]) if abs(nums[0]) in nums else nums[0]