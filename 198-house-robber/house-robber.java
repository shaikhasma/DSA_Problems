class Solution {
    public int rob(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return solv(arr, n - 1, dp);
    }
    int solv(int[] arr, int index, int[] dp){
        if(index < 0)
            return 0;

        if(index == 0)
            return arr[0];
        if(dp[index] != - 1)
            return dp[index];

        int pick = arr[index] + solv(arr, index - 2, dp);
        int notPick = solv(arr, index - 1, dp);

        return dp[index ] = Math.max(pick, notPick); 
    }
}