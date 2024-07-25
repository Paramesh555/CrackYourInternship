class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList();
        boolean[][] visited = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    q.add(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }

       int ans = 0;
        int[] dx ={1,-1,0,0};
        int[] dy = {0,0,1,-1};
        while(!q.isEmpty()){
            int size = q.size();
            boolean isAdded = false; 
            for(int i=0;i<size;i++){
                int[] point = q.remove(); 
                
                for(int d =0;d<4;d++){
                    
                    int newX =  point[0]+dx[d];
                    int newY = point[1]+dy[d];
                    if(newX >=0 && newY >= 0 && newX < n && newY < m 
                        && visited[newX][newY] == false &&grid[newX][newY] == 0){
                            visited[newX][newY] = true;
                            q.add(new int[]{newX,newY});
                            if(!isAdded){
                                isAdded = true;
                                ans++;
                            }

                    } 
                    
                }
                
            }
        }

        return ans == 0?-1:ans;
    }
}