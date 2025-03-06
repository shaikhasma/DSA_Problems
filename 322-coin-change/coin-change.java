/*
Approach. - Recursion 
    - index n - 1 to 0
    - pick same coin multiple time  
        - if current coint <= amount then pick count 1 coin picked 
            stand at that index only
            reduce amount by current index value of coin
    - Not pick move to previous index and keep amount as it is & dont count any coin
    - Final return 
        Math.min(pick , notPick)
    
    - Base Case 
       - single element index = 0
       - can be pick only if <= amount 
         e.g coin[0] = 2 amount = 6 
         if 6 % 2 == 0 Return 6 / 2 = 3 coin of 0th index can be pick
         return amount / coin[0]

TC - 0( >= 2^n) as we can pick same element multiple times
   - 0(N * T)
SC - 0(N*T) + 0(N)

Program - 
     public int coinChange(int[] coins, int amount) {
        int ans = solve(coins.length - 1, coins, amount);
         return ans == (int) 1e9 ? -1 : ans;
    }

    int solve(int index, int[] coins, int target){

        if(index == 0){
            
            if(target % coins[0] == 0)
                return target / coins[0];
            
            return (int) 1e9; // avoid counting
        }
        
        int pick = (int) 1e9;
        if(coins[index] <= target){
            pick = 1 + solve(index, coins, target - coins[index]);
        }

        int notPick = solve(index - 1, coins, target);

        return Math.min(pick, notPick);
    }


*/
class Solution {
    public int coinChange(int[] coins, int amount) {
       int[][] dp = new int[coins.length][amount + 1];
      
      //base case setting
       for( int target = 0; target <= amount ; target++){
           if(target % coins[0] == 0)
              dp[0][target] = target / coins[0];
           else
              dp[0][target] = (int) 1e9;
       }

       for(int index = 1; index < coins.length; index++){
           for(int target = 0; target <= amount; target++){
                //take
                int take = (int)1e9;
                if(coins[index] <= target)
                    take = 1 + dp[index][target - coins[index]];

                // not take
                int notTake = dp[index - 1][target];
                dp[index][target] = Math.min(take, notTake);
           }
       }

       int ans = dp[coins.length - 1][amount];
       return ans == (int) 1e9 ?  -1: ans;
    }

    int solve(int index, int[] arr, int target, int[][] dp){
        if(target == 0)
            return 0;

        if(index == 0){
            if(target % arr[index] == 0)
                return target / arr[index];

            return (int) 1e9;
        }

        if(dp[index][target] != -1)
            return dp[index][target];
       
       //take
       int take = (int)1e9;
       if(arr[index] <= target)
            take = 1 + solve(index, arr, target - arr[index],dp);

       // not take
       int notTake = solve(index - 1, arr, target, dp);

       return dp[index][target] = Math.min(take, notTake);
    }
}