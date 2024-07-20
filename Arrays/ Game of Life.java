class Solution {
    int[] dx = {1,1,1,-1,-1,-1,0,0};
    int[] dy = {1,-1,0,1,-1,0,1,-1};
    public void gameOfLife(int[][] board) {
        //now let us try in-place
        //we need to represent it's state
        //0 -> dead to dead
        //1 -> live to live
        //2 -> live to dead
        //3 -> dead to live
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j] = exploreAll(board,i,j);
                
            }
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j] = board[i][j]%2;
            }
        }

    }

    private int exploreAll(int[][] board,int i,int j){
        int count =0;
        for(int d=0;d<8;d++){
            int x = i+dx[d];
            int y = j + dy[d];
            if(x >=0 && y >=0 && x < board.length && y < board[0].length 
            && (board[x][y] == 1 || board[x][y] == 2)){
                count++;
            }
        }

        if(count <2){
            return board[i][j]== 0?0:2;
        } 
        if(count == 3 && board[i][j] == 0){
            //dead to live
            return 3;
        } 
        if(count == 2 || count == 3){
            
            return board[i][j] == 1?1:0;
        }
        //count is greater than 3
        return board[i][j] == 0?0:2;
    }
}

//time complexity : O(N)
//space complexity : O(1)