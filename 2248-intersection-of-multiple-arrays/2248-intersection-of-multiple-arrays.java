class Solution {
    public List<Integer> intersection(int[][] nums) {
        Set<Integer> set = getSet(nums[0]);
        for(int i=1; i<nums.length; i++) {
            Set<Integer> curr = getSet(nums[i]);
            set.retainAll(curr);
        }
        List<Integer> res = new ArrayList<>(set);
        Collections.sort(res);
        return res;
    }
    
    Set<Integer> getSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums) {
            set.add(i);
        }
        return set;
    }
}