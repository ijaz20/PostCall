class Solution {
    public int findKthLargest(int[] nums, int k) {
        TreeMap<Integer, Integer> freqMap = new TreeMap<>((a, b) -> b-a);
        for(int i : nums) {
            freqMap.merge(i, 1, Integer::sum);
        }
        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if(k-entry.getValue() <= 0) {
                return entry.getKey();
            }
            k -= entry.getValue();
        }
        return -1;
    }
}