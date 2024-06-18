class Solution {
    public int longestPalindromeSubseq(String s) {
        String s1 = s;
        String s2 = new StringBuilder(s).reverse().toString();
        return lcs(s1,s2);
    }

    int lcs(String s1, String s2){
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        for(int index1 = 1; index1 <= n; index1++){
            for( int index2 = 1; index2 <= m; index2++){
                //if both prev chars matches then 1 + take previous values 
                if(s1.charAt(index1 - 1) == s2.charAt(index2 - 1)){
                    dp[index1][index2] = 1 + dp[index1 - 1][index2 - 1];
                }else{
                    // take max  previous row & prevCol
                    dp[index1][index2] = Math.max(dp[index1 - 1][index2], dp[index1][index2 - 1]);
                }
            }
        }

        return dp[n][m];
    }
}