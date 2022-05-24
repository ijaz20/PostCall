class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length(), dp[] = new int[n], max = 0;
        for(int i=1; i<n; i++) {
            char c = s.charAt(i);
            if( c == ')' ) {
                if(s.charAt(i-1) == '(') {
                    dp[i] = i-2 >=0 ? dp[i-2] + 2 : 2;
                } 
                else if(dp[i-1] > 0 && i-1-dp[i-1]>=0 && s.charAt(i-1-dp[i-1]) == '(') {
                    dp[i] = dp[i-1] + 2;
                    dp[i] += i-dp[i] >=0 ? dp[i-dp[i]] : 0;
                }
                max = Math.max(dp[i], max);
            }
        }
        return max;
    }
}