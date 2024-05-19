/*. Approach - 3 Tabulation 
TC - 0(N)
SC - 0(N)   
     dp. 
*/
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int index = 2; index <= n; index++)
            dp[index] = dp[index - 1] + dp[index - 2];
        
        return dp[n];
    }
}