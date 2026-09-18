class Solution {
    public int maxProfit(int[] prices) {
      int n = prices.length;
      int maxi = 0;
      int left = 0;
      int right = 1;

      while(right < n ){
        if(prices[left] > prices[right]){
            left = right;
            right++;
        }else{
            int profit = prices[right] - prices[left];
            maxi = Math.max(maxi,profit);
            right++;
        }
      }  
      return maxi;
    }
}
