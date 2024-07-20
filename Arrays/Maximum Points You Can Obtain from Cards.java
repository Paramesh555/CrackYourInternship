class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        //it is same as finding subarray with least sum of n-k cards
        int n = cardPoints.length;
        

        int len = n - k;

        int[] prefixSum = new int[n+1];
        
        int minSum = Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            prefixSum[i] = prefixSum[i-1]+cardPoints[i-1];
            int targetIdx = i - len;
            if(targetIdx >=0){
                
                minSum = Math.min(minSum,prefixSum[i]-prefixSum[targetIdx]);
            }
        }

        return prefixSum[n] - minSum;
    }
    
    
}