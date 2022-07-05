class Solution {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        
        Map<Integer, Boolean> map = new HashMap<>();
        
        
        for(int i : nums) {
            map.put(i, false);
        }
        
        
        
        for(int i : map.keySet()) {
            boolean cur = map.get(i);
            int temp = 1;    
            if(cur == true)
                continue;
            
            else {
                map.put(i, true);
                int j = i;
                while(map.containsKey(j + 1)) {
                    temp++;
                    map.put(j + 1, true);
                    j = j + 1;
                }
                
            }
            max = Math.max(max, temp);
        }
        
        return max;
    }
}