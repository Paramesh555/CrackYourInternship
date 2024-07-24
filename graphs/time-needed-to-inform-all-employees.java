class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

        ArrayList<Integer>[] graph = new ArrayList[n];
        
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList();
        }

        for(int i=0;i<n;i++){
            int u = i;
            int v = manager[i];
            if(v == -1) continue;
            graph[v].add(u);
        }

        Queue<int[]> q = new LinkedList();
        q.add(new int[]{headID,0});
        int maxTime =0;
        while(!q.isEmpty()){
            int[] current = q.remove();
            int node = current[0];
            int currentTime = current[1];
            maxTime = Math.max(maxTime,currentTime);
            for(int neighbor : graph[node]){
                q.add(new int[]{neighbor,currentTime+informTime[node]});
            }
           
        }
        return maxTime;
    }
}