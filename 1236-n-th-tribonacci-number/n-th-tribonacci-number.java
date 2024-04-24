/*
   Approach - Bottom Up Approach without recursion
   TC - 0(N)
   SC - 0(1)
*/
class Solution {
    
    public int tribonacci(int n) {
         if(n == 0 ||  n == 1 )
            return n;
        if(n == 2)
            return 1;

      int[] dp = new int[n + 1];
      dp[0] = 0;
      dp[1] = 1;
      dp[2] = 1;
           
      for(int index = 3; index <= n; index++ ){
        dp[index] = dp[index - 1] + dp[index - 2] + dp[index - 3];
      }
    
    return dp[n];
        
    }

}