class Solution {
    public String addBinary(String a, String b) {
        int idx1 = a.length()-1;
        int idx2 = b.length()-1;
        StringBuilder sb = new StringBuilder();
        char carry = '0';
        while(idx1 >=0 && idx2 >=0){
            char temp1 = a.charAt(idx1);
            char temp2 = b.charAt(idx2);

            if(temp1 == '1' && temp2 == '1'){
                if(carry == '1'){
                    sb.append("1");
                }else{
                    sb.append("0");
                    carry = '1';
                }
            }else if(temp1 == '1' || temp2 == '1'){
                if(carry == '1'){
                    sb.append("0");
                    
                }else{
                    sb.append("1");
                }
            }else{
                sb.append(carry);
                carry = '0';
            }
            idx1--;
            idx2--;
        }

        while(idx1 >=0){
            if(carry == '1'){
                if(a.charAt(idx1) == '1'){
                    sb.append("0");
                }else{
                    sb.append("1");
                    carry = 0;
                }
            }else{
                sb.append(a.charAt(idx1));
            }
            idx1--;
        }

        while(idx2 >=0){
            if(carry == '1'){
                if(b.charAt(idx2) == '1'){
                    sb.append("0");
                }else{
                    sb.append("1");
                    carry = 0;
                }
            }else{
                sb.append(b.charAt(idx2));
            }
            idx2--;
        }
        if(carry == '1') sb.append(carry);
        return sb.reverse().toString();
    }
}