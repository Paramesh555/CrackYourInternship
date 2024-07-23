class Solution {
    public List<Integer> eventualSafeNodes(int[][] givenGraph) {
        //if we reverse the edges and search for indegree 0 nodes 

        ArrayList<Integer>[] graph = new ArrayList[givenGraph.length];
        int[] indegree = new int[givenGraph.length];
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList();
        }

        for(int i=0;i<givenGraph.length;i++){
            for(int j=0;j<givenGraph[i].length;j++){
                int u = i;
                int v = givenGraph[i][j];
                graph[v].add(u);//direction are reversed
                indegree[u]++;
            }
        }

        Queue<Integer> q = new LinkedList();

        for(int i=0;i<graph.length;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int v = q.remove();
            for(int i=0;i<graph[v].size();i++){
                int neighbor = graph[v].get(i);
                indegree[neighbor]--;
                if(indegree[neighbor] == 0){
                    q.add(neighbor);
                }
            }
        }
        
        List<Integer> ans = new ArrayList();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i] == 0){
                ans.add(i);
            }
        }

        return ans;
    }
}