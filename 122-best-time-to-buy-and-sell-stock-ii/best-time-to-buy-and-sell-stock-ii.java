/*
 0 1 2 3 4 5
[7,1,5,3,6,4]
output = 7

isBought = false
if isBought
  sell move next + false
else
  index  buy move next + true
  not buy

 profit max

 all possiblity on index plus max value after all possiblity 
 
 recursion

   0      false
f(index, isBuy)

 n return 0

 == based flag
       false
            buy -7
            not buy 0
        true
           sell 5 
           not sell 0

 0 1 2 3 4 5
[7,1,5,3,6,4]

3

-1 + 5 = 4
-3 + 6 = 3

4
TC - 0(2^N)
SC - 0(N) stack space

*/
class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int[] no : dp)
            Arrays.fill(no, -1);

        return solv(prices, 0, 0, dp);
    }

    int solv(int[] arr, int index, int isBuy, int[][] dp){
      if(index >= arr.length)
        return 0;

      int take = 0;
      int notTake = 0;
      
      if(dp[index][isBuy] != -1)
        return dp[index][isBuy];

      if(isBuy == 0){
        //can buy
        take = -arr[index] + solv(arr, index + 1, 1, dp);
        notTake = solv(arr, index + 1, 0, dp);
      }
      else{
        //can sell
        take =  arr[index] + solv(arr, index + 1, 0, dp);
        notTake = solv(arr, index + 1, 1, dp);
      }

      return dp[index][isBuy] = Math.max(take, notTake);
    }
}