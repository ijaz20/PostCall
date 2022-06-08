class Solution {
    public int removePalindromeSub(String s) {
        if(s.length() == 0) return 0;
        return new StringBuilder(s).reverse().toString().equals(s) ? 1: 2;
    }
}