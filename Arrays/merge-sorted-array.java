class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //if u do it from start we are not using that extra space 
        //but if we do from last then we are using that extra space

        int i1 = m-1;
        int i2 = n-1;

        int k = n+m-1;

        while(k >=0 && i1>=0 && i2>=0){
            if(nums1[i1] > nums2[i2]){
                nums1[k] = nums1[i1];
                i1--;
            }else{
                nums1[k] = nums2[i2];
                i2--;
            }
            k--;
        }

        while(i1>=0){
            nums1[k] = nums1[i1];
            i1--;
            k--;
        }

        while(i2>=0){
            nums1[k] = nums2[i2];
            i2--;
            k--;
        }
        
    }
}