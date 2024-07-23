class Solution 
{ 
	public static long[] productExceptSelf(int nums[], int n) 
	{ 
        // code here
        //no negative numbers
        
        int countOfZeroes = 0;
        long product = 1;
        long[] ans = new long[n];
        for(int num : nums){
            if(num == 0){
                countOfZeroes++;
                if(countOfZeroes > 1){
                    return ans;
                }
            }else{
                product *= num;
            }
        }
        
        for(int i=0;i<n;i++){
            if(countOfZeroes == 1){
                if(nums[i] == 0){
                    ans[i] = product;
                }else{
                    ans[i] = 0;
                }
            }else{
                ans[i] = product/nums[i];
            }
            
        }
        return ans;
	} 
} 
