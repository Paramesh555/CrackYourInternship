class Solution {
    class Pair{
        int height;
        int idx;
        Pair(int height,int idx){
            this.height = height;
            this.idx = idx;
        }
    }
    public int largestRectangleArea(int[] heights) {
        
        Stack<Pair> st = new Stack();
        int ans =0;
        for(int i=0;i<heights.length;i++){
            if(st.isEmpty()){
                st.push(new Pair(heights[i],i));
                continue;
            }

            if(st.peek().height > heights[i]){
                Pair temp =null;
                while(!st.isEmpty() && st.peek().height > heights[i]){
                    temp = st.pop();
                    ans = Math.max(ans,temp.height*(i-temp.idx));
                }
                
                st.push(new Pair(heights[i],temp.idx));
                
            }else{
                st.push(new Pair(heights[i],i));
            }
        }

        while(!st.isEmpty()){
            Pair temp = st.pop();
            ans = Math.max(ans,temp.height*(heights.length - temp.idx));
        }
        return ans;
    }
}