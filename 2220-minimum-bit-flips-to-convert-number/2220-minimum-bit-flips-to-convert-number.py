class Solution:
    def minBitFlips(self, start: int, goal: int) -> int:
        res = 0
        while start != 0 or goal !=0:
            res += (start  & 1) ^ (goal & 1)
            start >>= 1
            goal >>= 1
        return res