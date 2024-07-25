class DisjoinSet{
    List<Integer> size;
    List<Integer> parent;
    public DisjoinSet(int n){
        size = new ArrayList();
        parent = new ArrayList();

        for(int i=0;i<=n;i++){
            size.add(1);
            parent.add(i);
        }
    }

    public int findUPar(int node){
        if(node == parent.get(node)) return node;
        int p = findUPar(parent.get(node));
        parent.set(node,p);
        return p;
    }

    public void unionBySize(int node1,int node2){
        int p1 = findUPar(node1);
        int p2 = findUPar(node2);
        if(p1 != p2){
            if(size.get(p1) <size.get(p2)){
                parent.set(p1,p2);
                size.set(p2,size.get(p1) + size.get(p2));
            }else{
                parent.set(p2,p1);
                size.set(p1,size.get(p1) + size.get(p2));
            }
        }

    }
}

class Solution {

    public int removeStones(int[][] stones) {
        int maxRow =0;
        int maxCol = 0;
        //to figure out the max matrix
        for(int i=0;i<stones.length;i++){
            maxRow = Math.max(maxRow,stones[i][0]);
            maxCol = Math.max(maxCol,stones[i][1]);
        }

        DisjoinSet ds = new DisjoinSet(maxRow+maxCol+1);
        Map<Integer,Integer> mp = new HashMap();
        for(int i=0;i<stones.length;i++){
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1] + maxRow + 1;
            ds.unionBySize(nodeRow,nodeCol);
            mp.put(nodeRow,1);
            mp.put(nodeCol,1);
        }
        int count =0;
        for(Map.Entry<Integer,Integer> it : mp.entrySet()){
            if(ds.findUPar(it.getKey()) == it.getKey()){
                count++;
            }
        }
        return stones.length - count;
    }
}