/*
Approach - 1 Recursion
TC - 0(NM)
SC - 0(N) + 0(M)

Program - 
    
    public int minPathSum(int[][] grid) {
        return solv(grid, grid.length - 1, grid[0].length - 1);
    }

    int solv(int[][] grid, int row, int col){
        if(row < 0 || col < 0)
            return (int) 1e9;

        if(row == 0 && col == 0)
            return grid[row][col];

        int up = grid[row][col] + solv(grid, row - 1, col);
        int left = grid[row][col] + solv(grid, row, col - 1);

         return  Math.min( up , left);
    }

Approach - 2 Recursion + Memoiation
TC - 0(N*M)
TC - 0(N) + 0(M) + 0(NM) up + left + dp[][]

Program - 
*/
class Solution {
    public int minPathSum(int[][] grid) {
        int totRow = grid.length ;
        int totCol = grid[0].length;
     
        int[][] dp = new int[totRow][totCol];
        for( int[] row : dp)
            Arrays.fill(row, -1);

        return solv(grid, totRow - 1, totCol - 1,dp);
    }

    int solv(int[][] grid, int row, int col, int[][] dp){
        if(row < 0 || col < 0)
            return (int) 1e9; // invalid path

        if(row == 0 && col == 0)
            return grid[row][col];
        
        if(dp[row][col] != -1)
            return dp[row][col];

        int up = grid[row][col] + solv(grid, row - 1, col, dp);
        int left = grid[row][col] + solv(grid, row, col - 1, dp);

        return dp[row][col] =   Math.min( up , left);
    }
}