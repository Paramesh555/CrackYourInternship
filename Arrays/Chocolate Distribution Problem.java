class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        // your code here
        Collections.sort(a);
        
        int ans =Integer.MAX_VALUE;
        for(int i=m-1;i<a.size();i++){
            int temp = a.get(i) - a.get(i-m+1);
            ans = Math.min(temp,ans);
        }
        return ans;
    }
}