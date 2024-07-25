class Solution {
    static class Edge{
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        
    }
    
    static class DisjointSet {
        int[] parent, rank;
        int n;

        DisjointSet(int n) {
            this.n = n;
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        // Find the parent of a node 'u'
        int find(int u) {
            if (parent[u] != u) {
                parent[u] = find(parent[u]);
            }
            return parent[u];
        }

        // Union of two sets of 'u' and 'v'
        void union(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);

            
           
                if (rank[rootU] < rank[rootV]) {
                    parent[rootU] = rootV;
                } else if (rank[rootU] > rank[rootV]) {
                    parent[rootV] = rootU;
                } else {
                    parent[rootV] = rootU;
                    rank[rootU]++;
                }
            
        }
    }

    static int spanningTree(int V, int E, List<List<int[]>> adj) {
       
        //we can do minimum spanning tree by disjoint set by size
        List<Edge> edges = new ArrayList<>();
        
        for (int u = 0; u < V; u++) {
            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int weight = neighbor[1];
                edges.add(new Edge(u, v, weight));
            }
        }
        
        Collections.sort(edges, (a, b) -> Integer.compare(a.weight, b.weight));
        DisjointSet ds = new DisjointSet(V);
        int mstWeight = 0;
        int edgeCount = 0;
        
        for (Edge edge : edges) {
            int u = edge.src;
            int v = edge.dest;

            // Check if this edge forms a cycle
            if (ds.find(u) != ds.find(v)) {
                ds.union(u, v);
                mstWeight += edge.weight;
                edgeCount++;
            }

            // If we already have V-1 edges, break
            if (edgeCount == V - 1) {
                break;
            }
        }

        return mstWeight;
        
    }
}