class Solution {
    public int threeSumMulti(int[] arr, int target) {
        int mod = (int) 1e9 + 7, n = arr.length;
        long res = 0l;
        long[] dp = new long[101];
        for(int i : arr) dp[i]++;
        for(int i=0; i<101; i++) {
            for(int j=i; j<101; j++) {
                int k = target -i-j;
                if(k <0 || k>100) continue;
                if(i == j && j == k) {
                    res += (dp[i] * (dp[i]-1) * (dp[i]-2) ) /6 ;
                }
                else if(i == j && j != k) {
                    res += ((dp[i] * (dp[i]-1) ) / 2) * dp[k];
                } 
                else if(i < j && j < k) {
                    res += (dp[i] * dp[j] * dp[k]);
                }
            }
        }
        return (int) (res % mod);
    }
}