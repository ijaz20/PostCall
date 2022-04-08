class KthLargest {
    // 8 5 4 3 2vjghjghgjghjghj
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int size;
    public KthLargest(int k, int[] nums) {
        this.size = k;
        for(int i : nums){
            pq.offer(i);
        }
        while(pq.size() > k) pq.poll();
    }
    
    public int add(int val) {
        if(pq.size() < size){
            pq.offer(val);
        }
        else{
            if(val > pq.peek()){
                pq.offer(val);
                pq.poll();
            }
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */