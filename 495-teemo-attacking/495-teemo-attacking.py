class Solution:
    def findPoisonedDuration(self, ts: List[int], duration: int) -> int:
        res, n = 0, len(ts)
        for i, v in enumerate(ts):
            res += duration if i == n-1 else min(ts[i+1]-ts[i], duration)
        return res