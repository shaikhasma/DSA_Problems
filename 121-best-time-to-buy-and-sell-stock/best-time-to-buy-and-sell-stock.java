/*
  [7,4,5,3,6,1] 

  output  = 5
*/
class Solution {
    public int maxProfit(int[] arr) {
       int[] leftMin = prefixMin(arr);
       int[] rightMax = suffixMax(arr);
       int maxProfit = 0;

       for( int index = 0; index < arr.length ; index++)
        maxProfit = Math.max(maxProfit , rightMax[index] - leftMin[index]);

       return maxProfit;
    }

    int[] prefixMin(int[] arr){
        int[] ans = new int[arr.length];
        ans[0] = arr[0];

        for( int index = 1; index < arr.length; index++){
          if(ans[index - 1] > arr[index])
            ans[index] = arr[index];
          else
            ans[index] = ans[index - 1];
        }

        return ans;
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