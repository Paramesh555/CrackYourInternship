class Solution {
    public int maxArea(int[] height) {
        int ans =0;
        int left =0;
        int right = height.length -1;

        while(left < right){
            ans = Math.max(ans,(right - left) * Math.min(height[right],height[left]));
            
            if(height[left] > height[right]){
                right--;
            }else{
                left++;
            }
            
        }
        return ans;
    }
}