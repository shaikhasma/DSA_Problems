class Solution {
    public int maxProfit(int k, int[] arr) {
        int[][][] dp = new int[arr.length + 1][2][k + 1];
        
        for(int index = arr.length - 1; index >= 0; index--){
            for(int canBuy = 0 ; canBuy <=1 ; canBuy++){
                for(int tx = 1; tx <=k ; tx++){
                    int take = 0;
                    int notTake = 0;

                    if(canBuy == 0){
                      take = -arr[index] + dp[index + 1][1][tx];
                      notTake = dp[index + 1][0][tx];
                    }else{
                      take = arr[index] + dp[index + 1][0][tx - 1];
                      notTake = dp[index + 1][1][tx];
                    }

                  dp[index][canBuy][tx] = Math.max(take, notTake);
                }
            }
        }
        return dp[0][0][k];
    }

    int solv(int[] arr, int index, int canBuy, int tx, int[][][] dp){
        
        if(tx == 0 || index == arr.length)
            return 0;

        if(dp[index][canBuy][tx] != -1)
            return dp[index][canBuy][tx];

        int take = 0;
        int notTake = 0;

        if(canBuy == 0){
            take = -arr[index] + solv(arr, index + 1, 1, tx, dp);
            notTake = solv(arr, index + 1, 0, tx, dp);
        }else{
            take = arr[index] + solv(arr, index + 1, 0, tx - 1, dp);
            notTake = solv(arr, index + 1, 1, tx, dp);
        }

        return dp[index][canBuy][tx] = Math.max(take, notTake);
    }
}