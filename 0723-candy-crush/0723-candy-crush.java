class Solution {
    private static int N, M;
    public int[][] candyCrush(int[][] board) {
        N = board[0].length;
        M = board.length;
        boolean needGravity = true;
        
        while(needGravity){
            needGravity = false;
        
            for (int column = 0; column < N; column++) {
                for (int row = 0; row < M; row++) {
                    if(board[row][column] == 0) continue;
                    needGravity = crushCheck(board,row,column,needGravity);
                }       
            }
            
            if(needGravity){
                doGravity(board);
            }
          
        }
       
        return board;
    }

    public boolean crushCheck(int[][] board,int y, int x, boolean needGravity){
        int val = Math.abs(board[y][x]);
        
        if ((x + 2) <= (N-1)){
            if((Math.abs(board[y][x+1]) == val) && (Math.abs(board[y][x+2]) == val)){
                
                board[y][x] = val*-1;
                board[y][x+1] = val*-1;
                board[y][x+2] = val*-1;
                needGravity = true;
            }  
        }
    
        if ((y + 2) <= (M-1)){
            if((Math.abs(board[y+1][x]) == val) && (Math.abs(board[y+2][x]) == val)){
                
                board[y][x] = val*-1;;
                board[y+1][x] = val*-1;
                board[y+2][x] = val*-1;
                needGravity = true;
            }
        }   
        return needGravity;
    }
    
    public void doGravity(int[][] board){
        for (int column = 0; column < N; column++) { 
            
            int edit = (M - 1); 
            
            for (int row = (M - 1); row >= 0; row--) {
                if (board[row][column] > 0){
                    board[edit][column] = board[row][column];
                    edit--;
                }
            }
            
            for (int e = edit; e >= 0; e--){
                board[e][column] = 0;
            }
            
        }
    }
}