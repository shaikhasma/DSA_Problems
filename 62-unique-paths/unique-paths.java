/* Approach - 2 DP Memoization 
TC-0(n*m)
SC- 0(n*m)
*/
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] temp : dp){
            Arrays.fill(temp,-1);
        }
      
        return countPaths(0,0,m,n,dp);
    }

    int countPaths(int rowIndex, int colIndex,int row, int col,int[][] dp){
        if(rowIndex == row - 1 && colIndex == col - 1)
            return 1;
        if(rowIndex >= row || colIndex >= col)
            return 0;
        if(dp[rowIndex][colIndex] != -1)
          return dp[rowIndex][colIndex];

        return dp[rowIndex][colIndex] = 
               (countPaths(rowIndex + 1, colIndex, row, col, dp) 
                  + countPaths(rowIndex, colIndex + 1, row, col,dp) );
                
        
    }
}