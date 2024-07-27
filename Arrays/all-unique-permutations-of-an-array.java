class Solution {
    
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr
    , int n) {
        // code here
        Collections.sort(arr);
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        generate(new boolean[arr.size()],res,new ArrayList(),arr,0);
        return res;
    }
    
    private static void generate(boolean[] visited,ArrayList<ArrayList<Integer>> res 
        ,ArrayList<Integer> curr,ArrayList<Integer> arr,int i){
        
        if(i == arr.size()){
            res.add(new ArrayList(curr));
            return;
        }
        
        for(int j=0;j<arr.size();j++){
            if(!visited[j]){
                if(j == 0 || arr.get(j) != arr.get(j-1) || visited[j-1] == true){
                    curr.add(arr.get(j));
                    visited[j] = true;
                    generate(visited,res,curr,arr,i+1);
                    visited[j] = false;
                    curr.remove(curr.size() - 1);
                }
            }
        }
    }
};