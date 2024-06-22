class Solution {
    public int maxProfit(int[] arr, int fee) {
        int[][] dp = new int[arr.length][2];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        
        return solv(arr, 0, 0, fee, dp);
    }

    int solv(int[] arr, int index, int canBuy, int fee, int[][] dp){

        if(index == arr.length)
            return 0;

        if(dp[index][canBuy] != -1) 
            return dp[index][canBuy];

        int take = 0;
        int notTake = 0;
 
        if(canBuy == 0){
            take = -arr[index] + solv(arr, index + 1, 1, fee,dp);
            notTake = solv(arr, index + 1, 0, fee, dp);
        }
        else{
            take = arr[index] - fee + solv(arr, index + 1, 0, fee, dp);
            notTake = solv(arr, index + 1, 1, fee, dp);
        }

        return dp[index][canBuy] = Math.max(take, notTake);
    }
}