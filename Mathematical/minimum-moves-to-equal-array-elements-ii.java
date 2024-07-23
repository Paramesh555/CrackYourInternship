class Solution {
    public int minMoves2(int[] nums) {
       Arrays.sort(nums);
       int len = nums.length;
       int median = len /2;
       int ans =0;

       for(int num : nums){
            ans += Math.abs(num-nums[median]);
       } 

       return ans;
    }
}