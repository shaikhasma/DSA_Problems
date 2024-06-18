/* 
Approach - 1 Recursion
TC - 0(2^N * 2^M)
SC - -0(N + M)

Program - 
     public int longestCommonSubsequence(String text1, String text2) {
        return solv(text1, text1.length() - 1, text2, text2.length() - 1);
    }

    int solv(String str1, int index1, String str2, int index2){
        if(index1 < 0 || index2 < 0)
            return 0;

        if(str1.charAt(index1) == str2.charAt(index2)){
            return 1 + solv(str1, index1 - 1, str2 , index2 - 1);
        }

        return Math.max(solv(str1, index1 - 1, str2, index2), solv(str1, index1, str2, index2 - 1));

    }

Approach - 2. Recursion + Memorization
TC - 0(NM)
SC - -0(NM) + 0(N + M))
Program - 
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

Approach - 3. Tabulation
TC - 0(NM)
SC - -0(NM)
Program - 
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        
        // set 1st row & 1st col with 0
        for(int index = 0; index <= text1.length(); index++)
            dp[index][0] = 0;
        for(int index = 0; index <= text2.length(); index++)
            dp[0][index] = 0;

        for(int index1 = 1; index1 <= text1.length(); index1++){
            for( int index2 = 1; index2 <= text2.length(); index2++){

                if(text1.charAt(index1 - 1) == text2.charAt(index2 - 1))
                    dp[index1][index2] = 1 + dp[index1 - 1][index2 - 1];
                else
                    dp[index1][index2] = Math.max(dp[index1 - 1][index2] , dp[index1][index2 - 1]);
            }
        }
        
        return dp[text1.length()][text2.length()];
    }

*/
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        
        // set 1st row & 1st col with 0
        for(int index = 0; index <= text1.length(); index++)
            dp[index][0] = 0;
        for(int index = 0; index <= text2.length(); index++)
            dp[0][index] = 0;

        for(int index1 = 1; index1 <= text1.length(); index1++){
            for( int index2 = 1; index2 <= text2.length(); index2++){

                if(text1.charAt(index1 - 1) == text2.charAt(index2 - 1))
                    dp[index1][index2] = 1 + dp[index1 - 1][index2 - 1];
                else
                    dp[index1][index2] = Math.max(dp[index1 - 1][index2] , dp[index1][index2 - 1]);
            }
        }
        
        return dp[text1.length()][text2.length()];
    }
}