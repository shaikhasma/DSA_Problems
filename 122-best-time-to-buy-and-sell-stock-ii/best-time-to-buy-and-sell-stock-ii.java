class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return solv(prices, 0, 0, dp);
    }

    int solv(int[] arr, int index, int isBuy, int[][] dp){
        if(index == arr.length)
            return 0;

        if(dp[index][isBuy] != -1){
            return dp[index][isBuy];
        }

        int pick = 0;
        int notPick = 0;
        if(isBuy == 0){
            pick = -arr[index] + solv(arr, index + 1, 1, dp);
            notPick = solv(arr, index + 1, 0, dp);
        }
        else{
            pick = arr[index] + solv(arr, index + 1, 0, dp);
            notPick = solv(arr, index + 1, 1, dp);
        }

        return dp[index][isBuy] = Math.max(pick, notPick);
    }
}

/*
O(2^N)
0(N)
*/