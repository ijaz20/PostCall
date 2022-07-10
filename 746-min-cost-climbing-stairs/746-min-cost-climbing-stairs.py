class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        n = len(cost)
        dp = [inf] * (n+2)
        dp[0] = dp[1]=0
        for i in range(n):
            dp[i+1] = min(dp[i+1], dp[i]+cost[i])
            dp[i+2] = min(dp[i+2], dp[i]+cost[i])
        return min(dp[n], dp[n+1])