class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> seen = new HashSet<>();
        int n= s.length(), size = 1 << k; 
        for(int i=k; i <= n && seen.size() < size; i++) {
            seen.add(s.substring(i-k, i));
        }
        return seen.size() == size;
    }
}