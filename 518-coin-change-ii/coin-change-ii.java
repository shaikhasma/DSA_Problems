/*
Approach 1 - Recursion 

    1 2 5  target - 5

    5
    2 2 1
    2 1 1 1 
    1 1 1 1 1
    output 4
TC - 0(N*T)
SC - 0(N) stack

Program -   
    public int change(int amount, int[] coins) {
        return solv(coins, amount, coins.length - 1);
    }

    int solv(int[] coins, int target, int index){
        if(target == 0)
            return 1;

        if(index == 0)
            return target % coins[0] == 0 ? 1 : 0;
        

        int take = 0;
        if(coins[index] <= target)
            take = solv(coins, target - coins[index], index);
        
        int notTake = solv(coins, target, index - 1);

        return take + notTake;
    }

Approch - 2 Recursion + Memoiation 
TC - 0(NT)
SC - 0(NT) + 0(N)

Program - 
     public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        for(int[] row : dp)
            Arrays.fill(row, -1);

        return solv(coins, amount, coins.length - 1,dp);
    }

    int solv(int[] coins, int target, int index, int[][] dp){
        if(target == 0)
            return 1;

        if(index == 0)
            return target % coins[0] == 0 ? 1 : 0;
        
        if(dp[index][target] != -1) 
            return dp[index][target];

        int take = 0;
        if(coins[index] <= target)
            take = solv(coins, target - coins[index], index, dp);
        
        int notTake = solv(coins, target, index - 1, dp);

        return dp[index][target] = take + notTake;
    }

Approch - 3 Tabulation 
TC - 0(NT)
SC - 0(NT) 

Program -   
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        
        //Base case intilialization
        for(int target = 0; target <= amount ; target++)
            dp[0][target] = target % coins[0] == 0 ? 1  : 0;

        for(int index = 1; index < coins.length; index++){
            for(int target = 0; target <= amount; target++){
                
                int take = 0;
                if(coins[index] <= target)
                    take = dp[index][target - coins[index]];
                
                int notTake = dp[index - 1][target];
                
                dp[index][target] = take + notTake;
            }
        }
        return dp[coins.length - 1][amount];
    }

*/
class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        
        //Base case intilialization
        for(int target = 0; target <= amount ; target++)
            dp[0][target] = target % coins[0] == 0 ? 1  : 0;

        for(int index = 1; index < coins.length; index++){
            for(int target = 0; target <= amount; target++){
                
                int take = 0;
                if(coins[index] <= target)
                    take = dp[index][target - coins[index]];
                
                int notTake = dp[index - 1][target];
                
                dp[index][target] = take + notTake;
            }
        }
        return dp[coins.length - 1][amount];
    }
}