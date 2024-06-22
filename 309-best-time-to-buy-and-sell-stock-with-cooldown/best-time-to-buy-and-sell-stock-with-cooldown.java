class Solution {
    public int maxProfit(int[] arr) {
        int[][] dp = new int[arr.length + 2][2];
       

        for(int index = arr.length - 1; index >= 0; index--){
            for(int canBuy = 0 ; canBuy < 2; canBuy++){
               
               int take = 0;
               int notTake = 0;
               
               if(canBuy == 0 ){
                take = -arr[index] + dp[index + 1][1];
                notTake = dp[index + 1][0];
               }
               else{
                take = arr[index] + dp[index + 2][0];
                notTake = dp[index + 1][1];
               }

               dp[index][canBuy] = Math.max(take, notTake);
            }
        }

        return dp[0][0];
    }
}