class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int max_profit=0;
        int buy_price=prices[0];
        for(int i=0;i<n;i++){
            int curr_price=prices[i]-buy_price;
            if(curr_price>max_profit){
                max_profit=curr_price;

            }
            if(prices[i]<buy_price){
                buy_price=prices[i];
            }
        }
        return max_profit;
    }
}
