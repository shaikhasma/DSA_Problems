/* Approach - 2. Recursion + Memorization
TC - 0(NM)
SC - -0(NM) + 0(N + M))
*/
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];

        for(int[] row : dp)
            Arrays.fill(row, -1);
        
        return solv(text1, text1.length() - 1, text2, text2.length() - 1,dp);
    }

    int solv(String str1, int index1, String str2, int index2, int[][] dp){
        if(index1 < 0 || index2 < 0)
            return 0;

        if(dp[index1][index2] != -1)
            return dp[index1][index2];

        if(str1.charAt(index1) == str2.charAt(index2)){
            return dp[index1][index2] = 1 + solv(str1, index1 - 1, str2 , index2 - 1, dp);
        }

        return dp[index1][index2] = Math.max(solv(str1, index1 - 1, str2, index2, dp), solv(str1, index1, str2, index2 - 1, dp));

    }
}