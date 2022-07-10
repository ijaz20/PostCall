class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length, dp[] = new int[n+2];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = dp[1] = 0;
        for(int i = 0; i < n; i++) {
            dp[i+1] = Math.min(dp[i+1], dp[i] + cost[i]);
            dp[i+2] = Math.min(dp[i+2], dp[i] + cost[i]);
        }
        return Math.min(dp[n], dp[n+1]);
    }
}