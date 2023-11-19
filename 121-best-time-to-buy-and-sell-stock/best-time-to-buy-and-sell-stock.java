/** Approcah 2 Vally Approach
TC - 0(n)
SC - 0(1)
 */
class Solution {
    public int maxProfit(int[] price) { 
        int maxProfit = Integer.MIN_VALUE;
        int minPrice = Integer.MAX_VALUE;
      for(int index = 0 ; index < price.length ; index++){
          minPrice = Math.min(minPrice, price[index]);
          maxProfit = Math.max(maxProfit, price[index] - minPrice);
      }
      return maxProfit;
    }
}