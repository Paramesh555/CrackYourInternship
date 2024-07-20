class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList(); 
        
        Arrays.sort(nums);


        for(int i=0;i<nums.length;i++){
            if(i >0 && nums[i-1] == nums[i]) continue; // because duplicates are not allowed
            int low = i+1;
            int high = nums.length-1;
            while(low < high){
                int sum = nums[i]+nums[low]+nums[high];
                if(sum < 0){
                    low++;
                }else if(sum > 0){
                    high--;
                }else{
                    ans.add(Arrays.asList(nums[i],nums[low],nums[high]));
                    low++;
                    high--;
                }

                while(low < high && low > i+1 && nums[low] == nums[low-1]){
                    low++;
                }
            }
        }
        
        return ans;
    }
}