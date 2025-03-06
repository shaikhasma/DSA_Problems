/*
  [7,4,5,3,6,1] 

  output  = 5
*/
class Solution {
    public int maxProfit(int[] arr) {
       int minPrice = arr[0];
       int[] rightMax = suffixMax(arr);
       int maxProfit = rightMax[0] - minPrice;

       for( int index = 1; index < arr.length ; index++){
            minPrice = Math.min(minPrice, arr[index]);
            maxProfit = Math.max(maxProfit , rightMax[index] - minPrice);
       }

       return maxProfit;
    }

    int[] suffixMax(int[] arr){
        int[] ans = new int[arr.length];
        ans[arr.length - 1] = arr[arr.length - 1];

        for( int index = arr.length - 2; index >= 0 ; index--){
          if(arr[index] > ans[index + 1])
            ans[index] = arr[index];
          else
            ans[index] = ans[index + 1];
        }

        return ans;
    }
}