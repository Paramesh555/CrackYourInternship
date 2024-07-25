class Solution {
    public int findTheCity(int n, int[][] edges, int distThreshold) {
        int[][] dist= new int[n][n];
        for(int[] arr : dist){
            Arrays.fill(arr,-1);
        } 

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            dist[u][v] = wt;
            dist[v][u] = wt;

        }

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    
                    if(dist[i][k] != -1 && dist[k][j] !=-1){
                        if(dist[i][j] == -1 || dist[i][j] > dist[i][k] + dist[k][j])
                            dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        int[] ans = new int[n];
        for(int i=0;i<n;i++){
           for(int j=0;j<n;j++){
                if(dist[i][j] != -1 && i !=j && dist[i][j] <= distThreshold)
                    ans[i]++;
           }
        }

        int min = n;
        int res =0;
        for(int i=0;i<n;i++){
            if(min >= ans[i]){
                min = ans[i];
                res = i;
            }
        }
        return res;
    }
}