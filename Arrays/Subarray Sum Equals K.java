class Solution {
    public int subarraySum(int[] nums, int k) {
       
        int ans = 0;
        int prefixSum = 0;
        HashMap<Integer,Integer> map = new HashMap(); //sum value and freq
        map.put(0,1);
        
        for(int i=0;i<nums.length;i++){
            prefixSum += nums[i];
            if(map.containsKey(prefixSum - k)){
                ans += map.get(prefixSum - k);
            }
            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
        }
        return ans;

    }
}