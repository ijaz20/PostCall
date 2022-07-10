class Solution {
    public int fillCups(int[] amount) {
        var pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        pq.offer(amount[0]);
        pq.offer(amount[1]);
        pq.offer(amount[2]);
        int res =0;
        while(!pq.isEmpty()) {
            if(pq.peek() == 0) {
                pq.poll();
                continue;
            }
            int i = pq.poll();            
            if(!pq.isEmpty()) {
                int j = pq.poll();     
                if(--j > 0)
                    pq.offer(j);
            }
            if(--i > 0)
                pq.offer(i);
            res++;
        }
        return res;
    }
}