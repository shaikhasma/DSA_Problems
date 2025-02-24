class Solution {
    public int minDistance(String word1, String word2) {
       int[][] dp = new int[word1.length()][word2.length()];
       for(int[] arr : dp){
        Arrays.fill(arr, -1);
       }
        return solv(word1, word1.length() - 1, word2, word2.length() - 1 , dp);
    }

    int solv(String s1, int index1, String s2, int index2, int[][] dp){
        if(index1 < 0)
            return index2 + 1;
        if(index2 < 0)
            return index1 + 1;

        if(dp[index1][index2] != -1)
            return dp[index1][index2];

        if(s1.charAt(index1) == s2.charAt(index2))
            return solv(s1, index1 - 1, s2, index2 - 1, dp);
        
        int insert = 1 + solv(s1, index1, s2, index2 - 1, dp);
        int delete = 1 + solv(s1, index1 - 1, s2, index2, dp);
        int replace = 1 + solv(s1, index1 - 1, s2, index2 - 1, dp);

        return dp[index1][index2 ] = Math.min(insert, Math.min(delete, replace));
    }
}