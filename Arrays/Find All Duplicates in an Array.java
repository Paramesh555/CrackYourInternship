class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        //cycle sort
        int idx =0;
        while(idx < nums.length){
            int correctIdx = nums[idx] -1;
            if(nums[idx] != nums[correctIdx]){
                int temp = nums[idx];
                nums[idx] = nums[correctIdx];
                nums[correctIdx] = temp;
            }else{
                idx++;
            }
        }
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
        ArrayList<Integer> ans = new ArrayList();
       
        for(int i=0;i<nums.length;i++){
            if(nums[i] != i+1){
                ans.add(nums[i]);
            }
        }
        return ans;
    }
}
//time complexity : O(N)
//space Complexity : O(1)