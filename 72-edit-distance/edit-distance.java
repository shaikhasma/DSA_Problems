/*
 All possible minimum ==> Recursion
 N - 1   to 0
         
     i
 0 1 2 3 4
 h o r o s e 

     0 1 2
     r o s
     j
3


  0 1 2 3 4
0 0 1 2 3 4
1 1 0 0 0 0 
2 2 0 0 0 0


 char comparasion
    if equal not need to do anything i -- & j-- 
    else
    
    1 +     1. insert  j-- 
    1 +    2. delete  i-- 
    1 +    3. replace  i -- & j--

    return min(insert, min(delete, replace))
   
Base Case = 

if s1 < s2
    i
   -1 0 1 2
      r o s 
      0 1 2 3 4
      t d r o s
        j
      if  i < 0   j + 1 insert chars
      if  j < 0   i + 1 delete chars
*/
class Solution {
    public int minDistance(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
       
        for(int index = 0; index <= n; index++)
            dp[index][0] = index;
         for(int index = 0; index <= m; index++)
            dp[0][index] = index;
        

        for( int index1 = 1; index1 <= n; index1++){
            for (int index2 = 1; index2 <= m; index2++){
               
               if(s1.charAt(index1 - 1) == s2.charAt(index2 - 1))
                   dp[index1][index2] = dp[index1 - 1][index2 - 1];
               else{
                    int insert = 1 + dp[index1][index2 - 1];
                    int delete = 1 + dp[index1 - 1][index2];
                    int replace = 1 + dp[index1 - 1][index2 - 1];
                
                   dp[index1][index2] = Math.min(insert, Math.min(delete, replace));
               }
            }
        }
        return dp[n][m];
    }
}