class Solution {
    int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length, dp[][] = new int[m][n], max = Integer.MAX_VALUE;
        for(int[] i: dp) Arrays.fill(i, max);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        pq.offer(new int[]{0, 0, 0});
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int dis = curr[0], x = curr[1], y = curr[2];
            if(x==m-1 && y==n-1) return dis;
            for(int[] dir : dirs) {
                int i= x+dir[0], j= y+dir[1];                
                if(i < 0 || i>=m || j<0 || j>=n) continue;
                int newDist = Math.max(dis, Math.abs(heights[i][j] - heights[x][y]));
                if(dp[i][j] > newDist) {
                    dp[i][j] = newDist;
                    pq.offer(new int[]{newDist, i, j});
                }
            }
        }
        return dp[m-1][n-1];
    }
}