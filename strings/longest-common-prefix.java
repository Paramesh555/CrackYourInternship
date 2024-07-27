class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res = strs[0];
        for(int i=1;i<strs.length;i++){
            if(res.length() == 0 || strs[i].length() == 0) return "";
            int idx = 0;
            if(res.charAt(idx) == strs[i].charAt(idx)){
                int len = Math.min(res.length(),strs[i].length());
                while(idx<len && res.charAt(idx) == strs[i].charAt(idx)){
                    idx++;
                }
                res = res.substring(0,idx);//end index is exclusive
            }else{
                return "";
            }
        }
        return res;
    }
}