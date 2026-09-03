// class Solution {
//     public int maxProfit(int[] prices) {
//         int buyprice = prices[0];
//         int profit = 0;

//         for(int i=1; i<prices.length; i++){
//             if(prices[i] < buyprice){
//                 buyprice = prices[i];
//             }
//             int p = prices[i] - buyprice;
//             if(p > profit){
//                 profit = p;
//             }
//         }

//         return profit;
//     }
// }



class Solution {
    public int maxProfit(int[] prices) {

        int left = 0;
        int right = 1;
        int maxProfit = 0;

        while (right < prices.length) {

            if (prices[right] > prices[left]) {
                maxProfit = Math.max(maxProfit,
                                     prices[right] - prices[left]);
            } else {
                left = right;
            }

            right++;
        }

        return maxProfit;
    }
}