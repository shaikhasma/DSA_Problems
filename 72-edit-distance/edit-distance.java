/*
Intution building All possible minimum ==> Recursion
 N - 1   to o        
     i
    0 1 2 3 4
    h o r o s e 

     0 1 2
     r o s
     j
     = > 3
 char comparasion
    if equal not need to do anything i -- & j-- 
    else
    
    1 +     1. insert  j-- 
    1 +    2. delete  i-- 
    1 +    3. replace  i -- & j--

    return min(insert, min(delete, replace))
   
Base Case

    if s1 < s2
        i
    -1 0 1 2
        r o s 
        0 1 2 3 4
        t d r o s
            j
        if  i < 0   j + 1 insert chars
        if  j < 0   i + 1 delete chars

Approch - 1 Recursion 
TC - 0(3^N*M)
SC - 0(N + M)
Program - 
    public int minDistance(String word1, String word2) {
        return solv(word1, word2, word1.length() - 1, word2.length() -1 );
    }

    int solv(String s1, String s2, int index1, int index2){

        if(index1 < 0)
           return index2 + 1;
        if(index2 < 0)
           return index1 + 1;

        if(s1.charAt(index1) == s2.charAt(index2))
            return solv(s1, s2, index1 - 1, index2 - 1);
        
        int insert = 1 + solv(s1, s2, index1, index2 - 1);
        int delete = 1 + solv(s1, s2, index1 - 1, index2);
        int replace = 1 + solv(s1, s2, index1 - 1, index2 - 1);

        return Math.min(insert, Math.min(delete, replace));

    }

Approach - 2 Memorization 
*/
class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n][m];
        for(int[] row : dp)
            Arrays.fill(row, -1);

        return solv(word1, word2, n - 1, m -1 , dp);
    }

    int solv(String s1, String s2, int index1, int index2, int[][] dp){

        if(index1 < 0)
           return index2 + 1;
        if(index2 < 0)
           return index1 + 1;

        if(dp[index1][index2] != -1)
            return dp[index1][index2];

        if(s1.charAt(index1) == s2.charAt(index2))
            return solv(s1, s2, index1 - 1, index2 - 1, dp);
        
        int insert = 1 + solv(s1, s2, index1, index2 - 1, dp);
        int delete = 1 + solv(s1, s2, index1 - 1, index2, dp);
        int replace = 1 + solv(s1, s2, index1 - 1, index2 - 1, dp);

        return dp[index1][index2] = Math.min(insert, Math.min(delete, replace));
    }
}