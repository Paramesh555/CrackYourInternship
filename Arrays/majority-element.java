class Solution {
    public int majorityElement(int[] nums) {
        int count =1;
        int candidate = nums[0];

        for(int i=1;i<nums.length;i++){
            if(candidate == nums[i]){
                count++;
            }else{
                if(count == 0){
                    candidate = nums[i];
                }else{
                    count--;
                }
            }
        }
        return candidate;
    }
}