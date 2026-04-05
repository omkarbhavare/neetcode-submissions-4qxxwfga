class Solution {
    public int maxProfit(int[] prices) {


        int newMaxProfit=0;

        for(int i=0 ; i<prices.length -1 ;i++){
            for(int j=i+1 ; j< prices.length ; j++){
                if(prices[i]<prices[j] && newMaxProfit < prices[j]-prices[i]){
                    newMaxProfit = prices[j]-prices[i];
                }
            }
        }
        return newMaxProfit;
        
    }
}
