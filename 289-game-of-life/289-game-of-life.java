class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = getLive(board, i, j);
            }            
        }
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++){
                board[i][j] = board[i][j] >> 1;
            }
        }
    }
    
    int getLive(int[][] board, int i, int j) {
        int m = board.length, n = board[0].length, res = 0;
        int[][] dirs = { {0,1}, {1,0}, {0,-1}, {-1,0}, {-1,-1}, {-1, 1}, {1, -1}, {1,1} }; 
        for(int[] dir : dirs ) {
            int x = i+dir[0] , y = j+dir[1];
            if(x < 0 || x >=m||y <0||y>=n) continue; 
            res += (board[x][y] & 1);
        }
        if(board[i][j] == 1 ) {
            if(res == 2 || res == 3){
                return 3;
            } else{
                return 1;
            }
        } else {
            if(res == 3){
                return 2;
            } else {
                return 0;
            }
        }         
    }
}