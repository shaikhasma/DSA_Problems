/* Approach - Recursion + Memoization

[10,15,20]
      --- 2 [20]
   ---  1 [15]
--- 0 [10]

  Nth stairs == N - 1  , N  - 2
             min(cost.   cost)

  0th == 0
  1th  = 0
  TC - 0(N)
  SC - 0(N)   auxlillary space 0(2^N)

*/
class Solution {
    public int minCostClimbingStairs(int[] cost) {
       int[] dp = new int[cost.length + 1];
       Arrays.fill(dp, -1);
       return solve(cost, cost.length, dp);        
    }

    int solve(int[] cost, int n, int[] dp){
        if(n == 0 || n == 1 ) return 0;
        
        if(dp[n] != -1)
            return dp[n];
        
        return dp[n] = Math.min (
            solve(cost, n - 1, dp) + cost [n - 1], 
            solve(cost, n - 2, dp) + cost[n - 2]
        );
    }
}