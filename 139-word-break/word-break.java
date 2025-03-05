/*
 TC- 0(n^2) N diffrent state for each state n string
 SC - 0(N) stack , 0(M) set + 0(N)dp[] 
    - 0(2N + M)
Approach - Bottom Up
TC - 0(N^2)
SC- 0(N) dp array
*/
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet < String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;//base case or empty string always brekable
        for(int i = 1; i <= s.length(); i++){
            for( int j = 0; j < i; j++){
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}