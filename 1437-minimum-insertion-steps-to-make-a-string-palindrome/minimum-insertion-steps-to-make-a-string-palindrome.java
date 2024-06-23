/*
zzazz
zzazz
0

mbadm
mdabm
Oberservation. - 
-----------------
- We can make every String  as palindrome by attaching reverse of that string
- Max insertion will be always len of string

eg. 
Given      l e e t c o d e
new String l e e t c o d e + d o c t e e l

now we have to add different chacter which are not present in both string 
min insertion. =.String length - common character of these two string 

Approach - 1 Recursion 
TC - 0(2^N * 2^M)
SC - 0(N + M)
Program - 
     public int minInsertions(String s) {
        String strRev = new StringBuilder(s).reverse().toString();
        return s.length() - lcs(s, s.length() - 1, strRev, strRev.length() - 1);

    }
    
    int lcs(String s1, int index1, String s2, int index2){
        if(index1 < 0 || index2 < 0)
            return 0;
            
        if(s1.charAt(index1) == s2.charAt(index2))
            return 1 + lcs(s1, index1 - 1, s2, index2 - 1);
        
        int step1 = lcs(s1, index1 - 1, s2, index2);
        int step2 = lcs(s1, index1, s2, index2 - 1);

        return Math.max(step1, step2);
    }

Approach. - 2 Memorization
TC -
SC - 
    public int minInsertions(String s) {
        
        int[][] dp = new int[s.length()][s.length()];
        for(int[] row : dp)
            Arrays.fill(row, -1);
            
        String strRev = new StringBuilder(s).reverse().toString();
        return s.length() - lcs(s, s.length() - 1, strRev, strRev.length() - 1, dp);

    }
    
    int lcs(String s1, int index1, String s2, int index2, int[][] dp){
        if(index1 < 0 || index2 < 0)
            return 0;

        if(dp[index1][index2] != -1)
            return dp[index1][index2];

        if(s1.charAt(index1) == s2.charAt(index2))
            return 1 + lcs(s1, index1 - 1, s2, index2 - 1, dp);
        
        int step1 = lcs(s1, index1 - 1, s2, index2, dp);
        int step2 = lcs(s1, index1, s2, index2 - 1, dp);

        return dp[index1][index2] = Math.max(step1, step2);
    }

Approach - 3 Tabulation
TC - 
SC - 
Program - 
    public int minInsertions(String s1) {

        String s2 = new StringBuilder(s1).reverse().toString();
        return s1.length() - lcs(s1, s2);

    }
    
    int lcs(String s1, String s2){
        
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        
        
         //  As Base case setting 0 and default also zero so not required

        //As we are doing co-ordinates shift -1 means 1
        // initnialize base cases
        //1st col set 0
      //  for(int index = 0; index <= s1.length(); index++)
      //      dp[index][0] = 0;
        //1st row set 0
      //  for(int index = 0; index < s1.length(); index++)
        //    dp[0][index] = 0;
        
        for(int index1 = 1; index1 <= s1.length(); index1++){
            for( int index2 = 1; index2 <= s2.length(); index2++){

                if(s1.charAt(index1 - 1) == s2.charAt(index2 - 1))
                    dp[index1][index2] = 1 + dp[index1 - 1][index2 - 1];

                else{
                    int step1 = dp[index1 - 1][index2];
                    int step2 = dp[index1][index2 - 1];
                    dp[index1][index2] = Math.max(step1, step2);
                }
            }
        }
        
        return dp[s1.length()][s2.length()];
    }

Approach - 3  Space Optimization
TC - 
SC - 
Program -
    public int minInsertions(String s1) {

        String s2 = new StringBuilder(s1).reverse().toString();
        return s1.length() - lcs(s1, s2);

    }
    
    int lcs(String s1, String s2){
        int[] prevRow = new int[s2.length() + 1];

        for(int index1 = 1; index1 <= s1.length(); index1++){
            
            int[] currentRow = new int[s2.length() + 1];
            for( int index2 = 1; index2 <= s2.length(); index2++){

                if(s1.charAt(index1 - 1) == s2.charAt(index2 - 1))
                    currentRow[index2] = 1 + prevRow[index2 - 1];

                else{
                    int step1 = prevRow[index2];
                    int step2 = currentRow[index2 - 1];
                    currentRow[index2] = Math.max(step1, step2);
                }
            }
            prevRow = currentRow;
        }
        
        return prevRow[s2.length()];
    }
*/
class Solution {
    public int minInsertions(String s1) {

        String s2 = new StringBuilder(s1).reverse().toString();
        return s1.length() - lcs(s1, s2);

    }
    
    int lcs(String s1, String s2){
        int[] prevRow = new int[s2.length() + 1];

        for(int index1 = 1; index1 <= s1.length(); index1++){
            
            int[] currentRow = new int[s2.length() + 1];
            for( int index2 = 1; index2 <= s2.length(); index2++){

                if(s1.charAt(index1 - 1) == s2.charAt(index2 - 1))
                    currentRow[index2] = 1 + prevRow[index2 - 1];

                else{
                    int step1 = prevRow[index2];
                    int step2 = currentRow[index2 - 1];
                    currentRow[index2] = Math.max(step1, step2);
                }
            }
            prevRow = currentRow;
        }
        
        return prevRow[s2.length()];
    }
}




















