class Solution {
    public String convertToTitle(int columnNumber) {
        //here reminder is 0 which mean z
        int num = 26;
        StringBuilder sb = new StringBuilder();

        while(columnNumber > 0){
            int rem = columnNumber % num;
            System.out.println(rem);
            if(rem == 0){
                rem = 26;
                columnNumber -= 1;
            } 
            sb.append((char)('A' + rem-1));
            columnNumber /= num;
        }
        return sb.reverse().toString();

    }
}