class Solution {
    public boolean isPossible(int N,int P, int[][] prerequisites)
    {
        // Your Code goes here
        int[] indegree = new int[N];
        ArrayList<Integer>[] graph = new ArrayList[N];
        
        for(int i=0;i<N;i++){
            graph[i] = new ArrayList();
        }
        
        for(int i=0;i<P;i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            
            graph[v].add(u);
            indegree[u]++;
        }
        
        Queue<Integer> q = new LinkedList();
        for(int i=0;i<N;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        if(q.isEmpty()) return false; //they are no node's with zero indegree
        
        while(!q.isEmpty()){
            int node = q.remove();
            for(int neighbor : graph[node]){
                indegree[neighbor]--;
                if(indegree[neighbor] == 0){
                    q.add(neighbor);
                }
            }
        }
        
        for(int i=0;i<N;i++){
            if(indegree[i] !=0){
                return false;
            }
        }
        return true;
    }
    
}