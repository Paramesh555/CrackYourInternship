class Solution {
    public int maxProfit(int[] prices) {
        //we buy when the price is decreasing and  next day price gonna go up
        //we sell when the price is increasing and next day price gonna go down
        int profit =0;
        int buy =0,sell =0,days = prices.length;
        while(buy < days && sell < days){
            while(buy < days-1 && prices[buy+1] < prices[buy]){
                buy++;
            }
            sell = buy;//we can buy and sell on the same day
            while(sell < days-1 && prices[sell + 1] > prices[sell]){
                sell++;
            }
            profit += prices[sell] - prices[buy];
            buy = sell+1;
        }
        return profit;
    }
}