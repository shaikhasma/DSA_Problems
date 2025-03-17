class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        Boolean[] dp = new Boolean[s.length() + 1];
        for(String word : wordDict)
            set.add(word);

        return solve(s,set, dp);
    }

    boolean solve(String str,  HashSet<String> set, Boolean[] dp){
        if(str.isEmpty())
            return true;

        if(dp[str.length()] != null)
            return dp[str.length()];

        for(int index = 1 ; index <= str.length(); index++){
            if(set.contains(str.substring(0,index))){
                if(solve(str.substring(index), set, dp))   
                    return dp[str.length()] = true;
            }
        }

        return dp[str.length()] = false;
    }
}