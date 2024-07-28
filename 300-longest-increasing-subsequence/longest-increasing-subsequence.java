/*
 dp[N + 1][N + 1]
 currentIndex = 0 to N - 1
 prevIndex = -1 to N - 1
 
 -1 position

 co-ordinate shift
 -1 0 1.  n- 1 
 0  1 2.  n -1
*/
class Solution {
    public int lengthOfLIS(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];
        for(int[] row : dp)
            Arrays.fill(row, -1);

        return solv(arr, 0, -1, dp);
    }

    int solv(int[] arr,int index, int prevIndex, int[][] dp){
    // base case 
    if(index == arr.length)
      return 0;

     if(dp[index][prevIndex + 1] != -1)
        return dp[index][prevIndex + 1] ;

     //take
     int take = 0;
     if(prevIndex == -1 || arr[index] > arr[prevIndex]){
        take = 1 + solv(arr, index + 1, index, dp);
     }

     //notTake
     int notTake = solv(arr, index + 1, prevIndex, dp );

     return dp[index][prevIndex + 1] = Math.max(take, notTake);
   
    }
}