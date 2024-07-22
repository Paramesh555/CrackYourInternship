class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList();
        int prev =0;
        for(int i=0;i<nums.length-1;i++){
            if(i >0 && nums[i] == prev){
                continue;
            }
            prev = nums[i];
            int len = nums.length - (i+1);
            int subarray[] = new int[len];
            System.arraycopy(nums, i+1, subarray, 0, len);
            int newTarget = target - nums[i];
            List<List<Integer>> temp =  threeSum(subarray,newTarget,nums[i]); 
            for(List<Integer> res : temp){
                res.add(nums[i]);
                ans.add(new ArrayList(res));
            }
        }
        return ans;
    }

    public List<List<Integer>> threeSum(int[] nums,int target,int val) {

        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        for(int i=0;i<nums.length;i++){
            // if(nums[i] == val) continue;
            if(i >0 && nums[i-1] == nums[i]) continue; // because duplicates are not allowed
            int low = i+1;
            int high = nums.length-1;
            while(low < high){
                long sum =(long) nums[i]+nums[low]+nums[high];
                if(sum < target){
                    low++;
                }else if(sum > target){
                    high--;
                }else{
                    ans.add(new ArrayList(Arrays.asList(nums[i],nums[low],nums[high])));
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