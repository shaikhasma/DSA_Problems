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

Approach - 3 Tabulation + Bottom Up
TC - 0(NM)
SC - 0(NM) dp

Program - 
    public int minPathSum(int[][] grid) {
            int totRow = grid.length ;
            int totCol = grid[0].length;
        
            int[][] dp = new int[totRow][totCol];
        
            
            for( int row = 0; row < totRow; row++){
                for( int col = 0; col < totCol; col++){
            
                    if(row == 0 && col == 0){
                        dp[row][col] = grid[row][col];
                        continue;
                    }
                    
                    int up = grid[row][col];
                    int left = grid[row][col];

                    if(row > 0)
                        up += dp[row - 1][col];
                    else
                        up += (int) 1e9;

                    if(col > 0)
                        left += dp[row][col - 1];
                    else
                        left += (int) 1e9;
                    
                dp[row][col] = Math.min(up, left);
                }
            }

            return dp[totRow - 1][totCol - 1];
        }

Approach. - 4 Space Optimization 
TC - 0(NM)
SC - 0(N) + 0(N) currentRow & TempRow

Program -
    public int minPathSum(int[][] grid) {
            int totRow = grid.length ;
            int totCol = grid[0].length;
        
        int[] prevRow = new int[totCol];
            
            for( int row = 0; row < totRow; row++){
                
                int[] currentRow = new int[totCol];

                for( int col = 0; col < totCol; col++){
            
                    if(row == 0 && col == 0){
                        currentRow[col] = grid[row][col];
                        continue;
                    }
                    
                    int up = grid[row][col];
                    int left = grid[row][col];

                    if(row > 0)
                        up += prevRow[col];
                    else
                        up += (int) 1e9;

                    if(col > 0)
                        left += currentRow[col - 1];
                    else
                        left += (int) 1e9;
                    
                currentRow[col] = Math.min(up, left);
                }
                prevRow = currentRow;
            }

            return prevRow[totCol - 1];
        }
*/
class Solution {
    public int minPathSum(int[][] grid) {
        int totRow = grid.length ;
        int totCol = grid[0].length;
     
       int[] prevRow = new int[totCol];
           
        for( int row = 0; row < totRow; row++){
            
            int[] currentRow = new int[totCol];

            for( int col = 0; col < totCol; col++){
        
                if(row == 0 && col == 0){
                    currentRow[col] = grid[row][col];
                    continue;
                }
                
                int up = grid[row][col];
                int left = grid[row][col];

                if(row > 0)
                    up += prevRow[col];
                else
                    up += (int) 1e9;

                if(col > 0)
                    left += currentRow[col - 1];
                else
                    left += (int) 1e9;
                
              currentRow[col] = Math.min(up, left);
            }
            prevRow = currentRow;
        }

        return prevRow[totCol - 1];
    }
}