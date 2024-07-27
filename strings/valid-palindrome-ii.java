class Solution {
    public boolean validPalindrome(String s) {
        int i=0;
        int j= s.length() -1;
        boolean flag = false;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                if(!flag){
                    flag = true;
                    if(isPalindrome(s,i+1,j) || isPalindrome(s,i,j-1)){
                        return true;
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isPalindrome(String s,int i,int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}