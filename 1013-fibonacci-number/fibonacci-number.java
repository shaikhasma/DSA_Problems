/*
  Approach - Recursion
  0 1  1 2 3
  0 1  2 3 4
*/
class Solution {
    Integer[] dp;
    public int fib(int n) {
      dp = new Integer[n+1];
     
      return solv(n);
    }

    int solv(int n){
       if(n == 0 || n == 1)
            return n;
        if(dp[n] != null)
            return dp[n];

        int prev = solv(n - 1);
        int pPrev = solv(n - 2);

        return dp[n] = prev + pPrev;
    }
}