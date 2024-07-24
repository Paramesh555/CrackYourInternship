class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        //apply dfs when node is completely viisted then add it to the stack
        //after that transpose the graph
        //now pop each element from the stack and apply dfs wrt transposed graph
        boolean[] isVisited = new boolean[V];
        Stack<Integer> st = new Stack();
        
        for(int i=0;i<V;i++){
            if(!isVisited[i]){
                fillOrder(i,adj,isVisited,st);
            }
        }
        
        //transpose the graph
        
        ArrayList<ArrayList<Integer>> transposedAdj = transposeGraph(adj);
        boolean[] newVisited = new boolean[V];
        int ans =0;
        while(!st.isEmpty()){
            int v = st.pop();
            if(!newVisited[v]){
                ans++;
                dfs(v,transposedAdj,newVisited);
            }
        }
        
        return ans;
    }
    
    private void dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[] newVisited){
        
        newVisited[node] = true;
        for(int neighbor : adj.get(node)){
            if(!newVisited[neighbor])
                dfs(neighbor,adj,newVisited);
        }
        
    }
    
    private void fillOrder(int node,ArrayList<ArrayList<Integer>> adj
        ,boolean[] isVisited,Stack<Integer> st){
        
        isVisited[node] = true;
        
        for(int neighbor : adj.get(node)){
            if(!isVisited[neighbor])
                fillOrder(neighbor,adj,isVisited,st);
        }
        
        st.push(node);
    }
    
    private ArrayList<ArrayList<Integer>> transposeGraph(ArrayList<ArrayList<Integer>> adj) {
        int vertices = adj.size();
        ArrayList<ArrayList<Integer>> transposedAdj = new ArrayList<>(vertices);
        
        // Initialize the adjacency list for the transposed graph
        for (int i = 0; i < vertices; i++) {
            transposedAdj.add(new ArrayList<>());
        }
        
        // Traverse the original graph and fill the transposed graph
        for (int i = 0; i < vertices; i++) {
            for (int j : adj.get(i)) {
                transposedAdj.get(j).add(i);
            }
        }
        
        return transposedAdj;
    }
}
