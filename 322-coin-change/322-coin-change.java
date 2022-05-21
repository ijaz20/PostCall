class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1], max = (int)(1e4);
        Arrays.fill(dp, max);
        dp[0] = 0;
        for(int c : coins) {
            for(int i=c; i < dp.length; i++) {
                dp[i] = Math.min(dp[i], dp[i-c] + 1);
            }
        }
        return dp[amount] == max ? -1 : dp[amount] ;
    }   
}