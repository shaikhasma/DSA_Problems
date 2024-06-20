/*
Approach - 1 Recursion 
TC - 0(Exponential)
SC - 0(N + M) stack space
Program - 
    public boolean isMatch(String s2, String s1) {
        //s1 is pattern string can contain * , ?
        //s2 is normal string 
      return isMatch(s1, s2, s1.length() - 1, s2.length() - 1);
    }

    boolean isMatch(String s1, String s2, int index1 , int index2){

        if(index1 < 0  && index2 < 0 )
            return true;
        if(index1 < 0 && index2 >= 0)
            return false;
        if(index1 >= 0 && index2 < 0){
            return isAllStars(s1, index1);
        }

        if(s1.charAt(index1) == s2.charAt(index2) || s1.charAt(index1) == '?')
            return isMatch(s1, s2, index1 - 1, index2 - 1);
        
        if(s1.charAt(index1) == '*'){
            return isMatch(s1, s2, index1 - 1, index2) ||
                   isMatch(s1, s2, index1, index2 - 1);
        }

        return false;
    }

    boolean isAllStars(String str, int index1){
         for( int index = index1; index >=0; index--){
                if(str.charAt(index) != '*') 
                    return false;
            }
         return true;
    }
*/
class Solution {
    public boolean isMatch(String s2, String s1) {
        //s1 is pattern string can contain * , ?
        //s2 is normal string 
      int[][] dp = new int[s1.length()][s2.length()];
      for(int[] row : dp)
        Arrays.fill(row, -1);

      return isMatch(s1, s2, s1.length() - 1, s2.length() - 1,dp);
    }

    boolean isMatch(String s1, String s2, int index1 , int index2, int[][] dp){

        if(index1 < 0  && index2 < 0 )
            return true;
        if(index1 < 0 && index2 >= 0)
            return false;
        if(index1 >= 0 && index2 < 0){
            return isAllStars(s1, index1);
        }

        if(dp[index1][index2] != -1)
            return dp[index1][index2] == 1 ? true : false;

        if(s1.charAt(index1) == s2.charAt(index2) || s1.charAt(index1) == '?')
            dp[index1][index2] = isMatch(s1, s2, index1 - 1, index2 - 1, dp) ? 1 : 0;
        
        if(s1.charAt(index1) == '*'){
            dp[index1][index2] = isMatch(s1, s2, index1 - 1, index2, dp) ||
                   isMatch(s1, s2, index1, index2 - 1, dp) ? 1 : 0;
        }

        return dp[index1][index2] == 1 ? true : false;
    }

    boolean isAllStars(String str, int index1){
         for( int index = index1; index >=0; index--){
                if(str.charAt(index) != '*') 
                    return false;
            }
         return true;
    }
}