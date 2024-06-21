/*
  0  1 2 3 4 
  [1,2,3,4,5]

  profit = 2 - 1  = 1
           2 

  Max = sell - buy
  buy or not buy based on  isBuy = false 
  sell or not sell based on isBuy = true
  
  0 to  n - 1
  f(arr, 0 , false, 2)
  f(arr, index , isBuy, txt)
  
   if tx == 0 || indexx == n
     return 0

  
  if buy == false
     buy  -arr[index] + move next + true, tx
     not buy move next + false tx
  
  if buy == true
     sell arr[index] +move next + false tx  - 1
     not sell move next + true; tx

     max profit calcualte
  4

  TC - 0(N)
  SC - 0(N*2*2) +0(N)

  index n - 1 to 0
   buy 0 to 1


*/
class Solution {
    public int maxProfit(int[] arr) {
        int[][][] dp = new int[arr.length + 1][2 + 1][2 + 1];
        
        for(int index = arr.length - 1; index >= 0 ; index-- ){
            for(int buy = 0 ; buy <= 1; buy++){
                for(int  tx = 1; tx <= 2; tx++){
                    int take = 0;
                    int notTake = 0;
                    if(buy == 0){
                        take = -arr[index] + dp[index + 1][1][tx];
                        notTake = dp[index + 1][0][tx]; 
                    }
                    else{
                        take = arr[index] + dp[index + 1][0][tx - 1];
                        notTake = dp[index + 1][1][tx];
                    }
                    dp[index][buy][tx] = Math.max(take, notTake);
                }
            }
        }
        return dp[0][0][2];
    }



    int solv(int[] arr, int index, int canBuy, int tx, int[][][] dp){
       if(tx == 0 || index == arr.length)
            return 0;

       int take = 0;
       int notTake = 0;

       if(dp[index][canBuy][tx] != -1 )
            return dp[index][canBuy][tx];

        if(canBuy == 0){
            take = -arr[index] + solv(arr, index + 1, 1, tx, dp);
            notTake = solv(arr, index + 1, 0, tx,dp); 
        }
        else{
            take = arr[index] + solv(arr, index + 1, 0, tx - 1, dp);
            notTake = solv( arr, index + 1, 1, tx, dp);
        }

        return dp[index][canBuy][tx] = Math.max(take, notTake);

    }
}