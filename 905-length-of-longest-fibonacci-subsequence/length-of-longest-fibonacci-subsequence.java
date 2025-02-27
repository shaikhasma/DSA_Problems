/*
[1,2,3,4,5,6,7,8]
 1 2 3 5 8
 2 3 5 8
 3 4 7
 4 5
 6 7 
 8
apporach brute force 
 TC - 0(N^3)
 SC - 0(N)

 Approach 2 Memorization 
TC - 0(N^2)
SC.- 0(N)

*/
class Solution {
   
     public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        if (n < 3) 
            return 0; 

        // Map to store the index of each number
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(arr[i], i);
        }

        // DP table: dp[i][j] = longest length of Fibonacci-like subsequence ending at indices (i, j)
        int[][] dp = new int[n][n];
        int maxLen = 0;

        // Iterate over all pairs (i, j)
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                int target = arr[j] - arr[i]; // Find the previous number in the Fibonacci sequence
                
                if (target < arr[i] && indexMap.containsKey(target)) { // Ensure it's in increasing order
                    int k = indexMap.get(target); // Get index of the previous number

                    // Transition step: dp[i][j] = dp[k][i] + 1
                    dp[i][j] = dp[k][i] > 0 ? dp[k][i] + 1 : 3; // At least 3 elements needed
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }

        return maxLen;
    }
}
