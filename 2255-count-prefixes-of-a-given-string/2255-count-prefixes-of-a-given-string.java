class Solution {
    public int countPrefixes(String[] words, String s) {
        int res = 0;
        for(String w : words) {
            res += s.startsWith(w) ? 1 : 0;
        }
        return res;
    }
}