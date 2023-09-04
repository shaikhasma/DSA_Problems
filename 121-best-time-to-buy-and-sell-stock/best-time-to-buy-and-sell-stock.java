/** Approcah 3 Using Valley approach / kadanes algorithm
TC - 0(n)
SC - 0(1)
 */
class Solution {
    public int maxProfit(int[] price) { 
      int minPrice = Integer.MAX_VALUE;
      int maxProfit = Integer.MIN_VALUE;

      for(int day = 0; day < price.length; day++){
          minPrice = Math.min(minPrice, price[day]);
          maxProfit = Math.max(maxProfit, price[day] - minPrice);
      }

      return maxProfit;
    }
}