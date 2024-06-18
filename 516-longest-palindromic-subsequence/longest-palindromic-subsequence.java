/*
   Approach - 1 Tabulation 
     0 1 2 3 4
s1 = b b b a b
s2 = b a b b b
       0 1 2 3 4 5 
     0 0 0 0 0 0 0
     1 0 1 1 1 1 1
     2 0 1 2 2 2 0 
     3 0 0 0 0 0 0
     4 0 0 0 0 0 0
     5 0 0 0 0 0 0

     index1 = 1.  index2 = 1 b b
                  index2 = 2 b a max (,) 1
                  index2 = 3 b b 1
                  index2 = 4 b b 1
                  index2 = 5 b b 1

    index1 = 2.  index2 = 1 b a max (,) 1
                  index2 = 2 b b 1
                  index2 = 3 b b 1
                  index2 = 4 b b 1
                  index2 = 5 b b 1 

    TC = 0(NM)
    SC = 0(NM)
        Program - 
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

    Approach - Space Optimization
    TC - 0(NM)
    SC = 0(M) + 0(M)

    Program - 
        public int longestPalindromeSubseq(String s) {
        String s1 = s;
        String s2 = new StringBuilder(s).reverse().toString();
        return lcs(s1,s2);
    }

    int lcs(String s1, String s2){
        int n = s1.length();
        int m = s2.length();

        int[] prevRow = new int[m + 1];

        for(int index1 = 1; index1 <= n; index1++){
            int[] currentRow = new int[m +1];
            for( int index2 = 1; index2 <= m; index2++){
                //if both prev chars matches then 1 + take previous values 
                if(s1.charAt(index1 - 1) == s2.charAt(index2 - 1)){
                    currentRow[index2] = 1 + prevRow[index2 - 1];
                }else{
                    // take max  previous row & prevCol
                    currentRow[index2] = Math.max(prevRow[index2], currentRow[index2 - 1]);
                }
            }
            prevRow = currentRow;
        }

        return prevRow[m];
    }

*/  

class Solution {
    public int longestPalindromeSubseq(String s) {
        String s1 = s;
        String s2 = new StringBuilder(s).reverse().toString();
        return lcs(s1,s2);
    }

    int lcs(String s1, String s2){
        int n = s1.length();
        int m = s2.length();

        int[] prevRow = new int[m + 1];

        for(int index1 = 1; index1 <= n; index1++){
            int[] currentRow = new int[m +1];
            for( int index2 = 1; index2 <= m; index2++){
                //if both prev chars matches then 1 + take previous values 
                if(s1.charAt(index1 - 1) == s2.charAt(index2 - 1)){
                    currentRow[index2] = 1 + prevRow[index2 - 1];
                }else{
                    // take max  previous row & prevCol
                    currentRow[index2] = Math.max(prevRow[index2], currentRow[index2 - 1]);
                }
            }
            prevRow = currentRow;
        }

        return prevRow[m];
    }
}