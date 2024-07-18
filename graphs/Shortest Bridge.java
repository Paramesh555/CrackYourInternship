class Solution {
    int[] dx ={+1,-1,0,0};
    int[] dy = {0,0,+1,-1};
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean firstIslandFound = false;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, q);
                    firstIslandFound = true; // Mark island found
                    break; // Explore only the first island
                }
            }
            if (firstIslandFound) {
                break; // Exit after finding first island
            }
        }
        //now we need to find nearest 1's from the points in the q
        int steps =0;
        while(!q.isEmpty()){
            int size= q.size();
            for(int k=0;k<size;k++){
                int[] point = q.poll();
                for(int i=0;i<4;i++){
                    int x = point[0]+dx[i];
                    int y = point[1]+dy[i];
                    if(x>=0 && y >=0 && x < grid.length && y < grid[0].length){
                        if(grid[x][y] == 1){
                            return steps;
                        }
                        if(grid[x][y] == 0){
                            grid[x][y] = 2;
                            q.add(new int[]{x, y});
                        }
                    }
                }
            }
            steps++;
        }
        return -1;

    }

    
    private void dfs(int[][] grid,int i,int j,Queue<int[]> q){

        if(i <0 || j<0 || i>=grid.length || j >= grid[0].length || grid[i][j] != 1) return;
        grid[i][j] = 2;
        q.add(new int[]{i, j});
        
        dfs(grid,i+1,j,q);
        dfs(grid,i-1,j,q);
        dfs(grid,i,j+1,q);
        dfs(grid,i,j-1,q);
    }
}

//Time Complexity: O(n * m)

//Space Complexity: O(n * m)