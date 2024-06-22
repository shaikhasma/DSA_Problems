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
        int[][][] dp = new int[arr.length][2][k+1];

        for (int index = 0; index < arr.length; index++) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                Arrays.fill(dp[index][canBuy], -1);
            }
        }

        return solv(arr, 0, 0, k, dp);
    }

    int solv(int[] arr, int index, int canBuy, int tx, int[][][] dp){
        
        if(tx == 0 || index == arr.length)
          return 0; 

        if(dp[index][canBuy][tx] != -1)
            return dp[index][canBuy][tx] ;

        int take = 0;
        int notTake= 0;

        if(canBuy == 0){
            take = -arr[index] + solv(arr, index + 1, 1, tx, dp);
            notTake = solv(arr, index + 1, 0, tx, dp);
        }
        else{
            take = arr[index] + solv(arr, index + 1, 0, tx - 1, dp);
            notTake = solv(arr, index + 1, 1, tx, dp);
        }

        return dp[index][canBuy][tx] = Math.max(take, notTake);
    }
}