class Solution {

    public String getSmallestString(int n, int k) {
        char[] chars = new char[n];
        dfs(chars, k, n-1);
        return new String(chars);
    }

    void dfs(char[] chars, int k, int i) {
        if( i < 0) return;
        if(i+26 <= k) {
            chars[i] = 'z';
            dfs(chars, k-26, i-1);
        } else {
            int res= k-i;
            chars[i] = (char)((res -1) + 'a');
            dfs(chars, k-res, i-1);
        }
    }
}