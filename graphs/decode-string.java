class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<String> st = new Stack();
        int idx =0;
        while(idx < s.length()){
           if(Character.isDigit(s.charAt(idx))){
                int number =0;
                while(Character.isDigit(s.charAt(idx))){
                    number *= 10;
                    number += s.charAt(idx) -'0';
                    idx++;
                }
                st.add(""+number);
            }else if(s.charAt(idx) == '['){
                idx++;
                String temp = "";
                while(s.charAt(idx) >= 'a' && s.charAt(idx) <='z'){
                    temp += s.charAt(idx);
                    idx++;
                }
                st.add(temp);
            }else if(s.charAt(idx) == ']'){
                idx++;
                String temp = st.pop();
                int multiplier = Integer.parseInt(st.pop());
                String newStr = temp.repeat(multiplier);
                if(st.isEmpty()){
                    sb.append(newStr);
                }else{
                    if(isNumber(st.peek())){
                        st.push(newStr);
                    }else{
                        String res = st.pop() + newStr;
                        st.push(res);
                    }
                    
                }
                
            }else{
                if(st.isEmpty()){
                    sb.append("" + s.charAt(idx));
                }else{
                    String res = st.pop() + s.charAt(idx);
                    st.push(res);
                }
                idx++;
            }
        }
        return sb.toString();
    }

    private boolean isNumber(String input) {
        try {
            // Attempt to parse the input as an integer
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            // If parsing fails, it's not an integer
            return false;
        }
    }
}