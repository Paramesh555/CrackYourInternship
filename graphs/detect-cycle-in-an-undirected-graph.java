class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] isVisited = new boolean[V];
        
    
        for(int i=0;i<V;i++){
           if(!isVisited[V]){
               if(hasCycle(i,adj,-1,isVisited)){
                    return true;
                }
           }
                
        }
        return false;
    }
    
    private boolean hasCycle(int V, ArrayList<ArrayList<Integer>> adj,int parent
    ,boolean[] isVisited,){
        
        isVisited[V] = true;
        for(int neighbor : adj.get(V)){
            if(!isVisited[neighbor]){
                if(hasCycle(neighbor,adj,V,isVisited)){
                    return true;
                }
            }else if(parent != neighbor){
                return true;
            }
        }
        return true;
    }
}