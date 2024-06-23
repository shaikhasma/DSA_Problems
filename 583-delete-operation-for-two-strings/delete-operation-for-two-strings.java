/* Approach - Longest common Subsequence using Tabulation
leetcode == > etco

take lcs (s1, s2)
s1.length() - lcs
Obersvation
     - Need to remove diff character from s1 to make it equal with common chars of s1 & s2
     - Need to add diff in to common set to make it s2
     - total operation  = delete from s1 + add into common set to make it s2
        
        s1.    s2.     lcs
        sea.    eat     ea
    1. s1 to lcs
        s remove (1)
    2. lcs to s2
          add t to se(1)
    total operation 1 + 1
    = 2

total min operation = s1.length - lcs(delete ) + s2.length - lcs ( add)
TC - 0(NM)
SC - 0(NM)
*/
class Solution {
    public int minDistance(String word1, String word2) {
        int lcs = lcs(word1, word2);
        return (word1.length() - lcs) + (word2.length() - lcs);
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