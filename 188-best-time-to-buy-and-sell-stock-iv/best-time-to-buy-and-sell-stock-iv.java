/*
    ============================================My Note ============================================================
Approach - 1 Recursion
TC - 0(2^N)
SC - 0(N)

Program - 
    public int maxProfit(int k, int[] arr) {
        return solv(arr, 0, 0, k);
    }

    int solv(int[] arr, int index, int canBuy, int tx){
        
        if(tx == 0 || index == arr.length)
          return 0; 

        int take = 0;
        int notTake= 0;

        if(canBuy == 0){
            take = -arr[index] + solv(arr, index + 1, 1, tx);
            notTake = solv(arr, index + 1, 0, tx);
        }
        else{
            take = arr[index] + solv(arr, index + 1, 0, tx - 1);
            notTake = solv(arr, index + 1, 1, tx);
        }

        return Math.max(take, notTake);
    }

*/
class Solution {
    public int maxProfit(int k, int[] arr) {
        int[][][] dp = new int[arr.length + 1][2][k+1];

        for(int index = arr.length - 1; index >= 0; index--){
            for(int canBuy = 1; canBuy >= 0; canBuy--){
                for(int tx = 1; tx <= k; tx++){
                    int take = 0;
                    int notTake = 0;
                    if(canBuy == 0){
                        take = -arr[index] + dp[index + 1][1][tx];
                        notTake = dp[index + 1][0][tx];
                    }
                    else{
                        take = arr[index] + dp[index + 1][0][tx - 1 ];
                        notTake = dp[index + 1][1][tx];
                    }

                    dp[index][canBuy][tx] = Math.max(take, notTake);
                }
            }
        }
        return dp[0][0][k];
    }
}