/*
 0 1 2 3 4 5
"a b c d e",

 0 1 2
"a c e"

    a c e
a b c d e
 index1 < 0 && index2 < 0
   return 0;
 index1 < 0 && index2 >= 0
   return 0;
  index2 < 0 && index1 >= 0
       return 0;

f(s1, d2, index1, index2)
common count & move index1 , index2
diff 
    step1  + index1 move index2
    step1  + index1 , index2 move

  return Max step1, step2
Approach - 1 Recursion 
TC - 0(2^ N * M)
SC - 0(N+M)

Program - 
    public int longestCommonSubsequence(String s1, String s2) {
        return solv(s1, s1.length() - 1, s2, s2.length() - 1);
    }

    int solv(String s1, int index1, String s2, int index2){
        if(index1 < 0 || index2 < 0)
            return 0;
        
        if(s1.charAt(index1) == s2.charAt(index2))
            return 1  + solv(s1, index1 - 1, s2, index2 - 1);
        
        int step1 = solv(s1, index1 - 1, s2, index2);
        int step2 = solv(s1, index1, s2, index2 - 1);

        return Math.max(step1, step2);
    }

Approach - 2 Recursion + Memorization 
TC - 0(N*M)
SC - 0(NM) + 0(N + M)

Program - 
     public int longestCommonSubsequence(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        for(int[] row : dp)
            Arrays.fill(row, -1);

        return solv(s1, s1.length() - 1, s2, s2.length() - 1, dp);
    }

    int solv(String s1, int index1, String s2, int index2, int[][] dp){
        if(index1 < 0 || index2 < 0)
            return 0;
        
        if(dp[index1][index2] != -1)
            return dp[index1][index2];

        if(s1.charAt(index1) == s2.charAt(index2))
            return 1  + solv(s1, index1 - 1, s2, index2 - 1, dp);
        
        int step1 = solv(s1, index1 - 1, s2, index2, dp);
        int step2 = solv(s1, index1, s2, index2 - 1, dp);

        return dp[index1][index2] = Math.max(step1, step2);
    }

Approach - 3 Tabulation
TC - 0(N*M)
SC - 0(NM) 
Note - 
    1. Need co-ordinate shift 
    2. base index1 < 0 || index2 < 0 will become index1 == 0 index2 == 0
        as index1 = 0 actual ans 1
    3. base index1 == 0 || index2 == 0
        if index1 is 0 then index2 can any thing and vice versa
        so set dp 1st column & 1st row to 0 

Program - 
*/
class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        
        //1st  col 0
        for(int index = 0; index <= s1.length(); index++)
            dp[index][0] = 0;
          //1st  row 0
        for(int index = 0; index <= s2.length(); index++)
            dp[0][index] = 0;

        for(int index1 = 1; index1 <= s1.length(); index1++){
            for(int index2 = 1; index2 <= s2.length(); index2++){
            
                if(s1.charAt(index1 - 1) == s2.charAt(index2 - 1))
                    dp[index1][index2] =  1  + dp[index1 - 1][index2 - 1];
                else{
                    int step1 = dp[index1 - 1][index2];
                    int step2 = dp[index1][index2 - 1];
                    dp[index1][index2] = Math.max(step1, step2);
                }
            }
        }

        return dp[s1.length() ][s2.length()];
    }
}