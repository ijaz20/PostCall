class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length, i=0, j=0, sum=0, max = 0;
        Set<Integer> vis = new HashSet<>();
        while(j < n) {
            if(vis.add(nums[j])) {
                sum += nums[j++];
                max = Math.max(max, sum);
            }
            else {
                sum -= nums[i];
                vis.remove(nums[i++]);
            }
        }
        return max;
    }
}