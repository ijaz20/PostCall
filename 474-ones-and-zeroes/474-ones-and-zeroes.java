class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp= new int[m+1][n+1];
        for(String s : strs ) {
            int[] count = count(s);
            for(int zero=m; zero-count[0]>=0;zero--){
                for(int one=n; one-count[1]>=0; one--){
                    dp[zero][one] = Math.max(dp[zero][one], dp[zero-count[0]][one-count[1]] + 1);
                }                
            }
        }
        return dp[m][n];
    }
    
    int[] count(String s) {
        int[] count = new int[2];
        for(char c : s.toCharArray()) {
            count[c-'0']++;
        }
        return count;
    }
}