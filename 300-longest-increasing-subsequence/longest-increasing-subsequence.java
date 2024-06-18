
class Solution {
    public int lengthOfLIS(int[] arr) {
       int[][] dp = new int[arr.length + 1][arr.length + 1];
      
       for( int index = arr.length - 1; index >= 0; index--){
            for(int prev = index - 1 ; prev >= -1 ; prev--){
        
                int pick = 0;
                if( prev == -1 || arr[prev] < arr[index])
                    pick = 1 + dp[index + 1][index + 1];
            
                int notPick = dp[index + 1][prev + 1];
                dp[index][prev + 1] = Math.max(pick, notPick);
            }
       }
       return dp[0][0];
    }
}