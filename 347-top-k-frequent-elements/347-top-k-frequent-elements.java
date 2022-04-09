class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        List<Integer>[] buckets = new List[n+1];
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int i : nums)
            freqMap.merge(i, 1, Integer::sum);
        
        for(Integer key : freqMap.keySet()){
            int value = freqMap.get(key);
            if(buckets[value] == null){
                buckets[value] = new ArrayList<>();
            }
            buckets[value].add(key);
        }
        for(int i =n; i>0 && k >0 ; i--){
            if(buckets[i] !=null){
                res.addAll(buckets[i]);
                k -= buckets[i].size();
            }
        }
        return res.stream().mapToInt(i->i).toArray();
    }
}