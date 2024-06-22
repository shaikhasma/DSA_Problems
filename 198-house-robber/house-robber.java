class Solution {
    public int rob(int[] arr) {
        int n = arr.length;
        
        int[] dp = new int[n];
        dp[0] = arr[0];

        for( int index = 1; index < n; index++){

            int take = arr[index];
            if(index > 1)
                take += dp[index - 2];
            
            int notTake = dp[index - 1];

            dp[index] = Math.max(take, notTake);
        }

        return dp[n - 1];
    }
    
}