class Solution:
    def triangularSum(self, nums: List[int]) -> int:
        n, res = len(nums)-1, 0
        while n > 0:
            for i in range(n):
                nums[i] = (nums[i] + nums[i+1])%10
                # print(nums[i], end = ' ')
            # print(' ')
            n-=1
        return nums[0]