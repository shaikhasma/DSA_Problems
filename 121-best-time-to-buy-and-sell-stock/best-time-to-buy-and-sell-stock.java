/*
  [7,4,5,3,6,1] 

  output  = 5
*/
class Solution {
    public int maxProfit(int[] arr) {
       int minPrice = arr[0];
       int maxProfit = 0;

       for( int index = 1; index < arr.length ; index++){
            minPrice = Math.min(minPrice, arr[index]);
            maxProfit = Math.max(maxProfit , arr[index] - minPrice);
       }

       return maxProfit;
    }

   
}