class Solution {
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length, sum =0;
        for(int i=0; i<n ; i++) {
            for(int j=0; j<n; j++) {
                if(i == j || i+j == n-1) {
                    if(grid[i][j] == 0)
                        return false;
                } else {
                    sum += grid[i][j];
                }
            }
        }
        // System.out.println(sum);
        return sum ==0;        
    }
}