/*
 TC- 0(n^2) N diffrent state for each state n string
 SC - 0(N) stack , 0(M) set + 0(N)dp[] 
    - 0(2N + M)
*/
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet < String> set = new HashSet<>(wordDict);
        Boolean[] dp = new Boolean[s.length() + 1];
        return solve(s, set, dp);
    }

    boolean solve(String s, HashSet<String> set, Boolean[] dp ){
        if(s.isEmpty())
            return true;

        //using memoization
        if(dp[s.length()] != null)
            return dp[s.length()];

        for(int index = 1; index <= s.length(); index++){
            String subStr = s.substring(0, index);
  
            if(set.contains(subStr)){
                if(solve(s.substring(index), set, dp)){
                    return dp[s.length()] = true;
                }
            }
        }

        return dp[s.length()] = false;
    }
}