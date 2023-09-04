/** Approcah 2 Using RightPrefix
TC - 0(n)
SC - 0(n)
 */
class Solution {
    public int maxProfit(int[] price) { 
      int[] rightPrefix = new int[price.length];
      int maxProfit = Integer.MIN_VALUE;

      rightPrefix[price.length - 1] = price[price.length - 1];
      for(int index = price.length - 2; index >= 0; index--){
          rightPrefix[index] = Math.max(rightPrefix[index + 1] , price[index]);
      }
     
      for(int currDay = 0; currDay< price.length; currDay++){
        maxProfit = Math.max(maxProfit, rightPrefix[currDay] - price[currDay]);
      }

      return maxProfit;
    }
}