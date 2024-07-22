class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n -1) return -1;
        //we need to know no of individual networks
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList();
        }
        for(int i=0;i<connections.length;i++){
            int u = connections[i][0];
            int v = connections[i][1];
            graph[u].add(v);
            graph[v].add(u);
        }
        boolean[] isVisited = new boolean[n];
        int count =0;
        for(int i=0;i<n;i++){
            if(!isVisited[i]){
                isVisited[i] = true;
                count++;
                dfs(i,graph,isVisited);
            }
        }
        return count-1;

    }

    private void dfs(int node,ArrayList<Integer>[] graph,boolean[] isVisited){

        for(int neighbor : graph[node]){
            if(!isVisited[neighbor]){
                isVisited[neighbor] = true;
                dfs(neighbor,graph,isVisited);
            }
        }

    }
}