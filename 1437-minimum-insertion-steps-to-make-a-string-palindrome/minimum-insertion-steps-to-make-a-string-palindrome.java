/* Approach - Longest Common Subsequence using Tabulation 
mbadm
mdabm
Take lcs (s, rev(s))
s.length - lcs

TC - 0(NM)
SC - 0(NNM)

*/
class Solution {
    public int minInsertions(String s1) {
        String s2 = new StringBuilder(s1).reverse().toString();
        int lcs = lcs(s1,s2);  
        return s1.length() - lcs;      
    }

    int lcs(String s1, String s2){
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for(int index1 = 1; index1 <= s1.length(); index1++ ){
            for(int index2 = 1; index2 <= s2.length(); index2++){
                
                if(s1.charAt(index1 - 1) == s2.charAt(index2 - 1))
                    dp[index1][index2] = 1 + dp[index1 - 1][index2 - 1];
                else
                    dp[index1][index2] = Math.max(dp[index1 - 1][index2], dp[index1][index2 - 1]);
            }

        }

        return dp[s1.length()][s2.length()];
    }
}