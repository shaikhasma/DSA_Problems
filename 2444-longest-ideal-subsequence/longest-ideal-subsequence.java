/*
  Approach - Recursion
  TC - 0(2^N)
  SC - 0(N)

*/
class Solution {
    public int longestIdealString(String s, int k) {
        return solv(s,k,0,0);
    }

    int solv(String s, int k, int index, int prev){
       int dp[][] = new int[s.length() + 1][27];
        // memset(dp, 0, sizeof(dp));
        for(int row = 1; row <= s.length(); row++){
            for(int col = 0; col <= 26; col++){
                if(col == 26){
                    dp[row][col] = Math.max(dp[row][col], 1 + dp[row-1][s.charAt(row-1)-'a']);
                }
                else if(Math.abs(s.charAt(row - 1) -'a'- col) <= k){
                    dp[row][col] = Math.max( dp[row][col], 1 + dp[row-1][s.charAt(row-1)-'a']);
                }
                dp[row][col] = Math.max( dp[row][col], dp[row-1][col]);
            }
        }
        return dp[s.length()][26];
    }
}