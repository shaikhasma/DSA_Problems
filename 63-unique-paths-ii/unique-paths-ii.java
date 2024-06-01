/* Approach 1 - Recursion 
TC - 0(2^NM)
SC - 0(2^NM)

Program
    public int uniquePathsWithObstacles(int[][] grid) {
        int totRow = grid.length;
        int totCol = grid[0].length;
      
        if(grid[totRow - 1][totCol - 1] == 1 || grid[0][0] == 1)
            return 0;

        return solv(grid, totRow - 1, totCol - 1);
    }

    int solv(int[][] grid, int row, int col){
        if(row == 0 && col == 0)
            return 1;
        if( row < 0 || col < 0 || grid[row][col] == 1 )
            return 0;

        int up = solv(grid, row - 1, col);
        int left = solv(grid , row, col - 1);
        
        return up + left;
    }

Approach 2 - Recursion + Memoiation
TC - 0(NM)
TC - 0(NM) + 0(NM)

Program - 
    class Solution {
        Integer[][] dp ;
        public int uniquePathsWithObstacles(int[][] grid) {
            int totRow = grid.length;
            int totCol = grid[0].length;
            dp = new Integer[totRow][totCol];
        
            if(grid[totRow - 1][totCol - 1] == 1)
                return 0;

            return solv(grid, totRow - 1, totCol - 1);
        }

        int solv(int[][] grid, int row, int col){
            if( row < 0 || col < 0 )
                return 0;
            if(grid[row][col] == 1 )
                return 0;
            if(row == 0 && col == 0)
                return 1;

            if(dp[row][col] != null)
                return dp[row][col];

            int up = solv(grid, row - 1, col);
            int left = solv(grid , row, col - 1);
            
            return dp[row][col] =  up + left;
        }
    }

Approach - Tabulation / Bottom Up
0 1
0 0
*/
class Solution {
    
    public int uniquePathsWithObstacles(int[][] grid) {
        int totRow = grid.length;
        int totCol = grid[0].length;
        int[][] dp = new int[totRow][totCol];      
        
        for(int[] row : dp ){
            Arrays.fill(row, -1);
        }

        for( int row = 0; row < totRow; row++){
            for(int col = 0; col < totCol; col++){
                
                if(row == 0 && col == 0 && grid[row][col] == 0){
                    dp[row][col] = 1;
                    continue;
                }

                if(grid[row][col] == 1 ){
                    dp[row][col] = 0;
                    continue;
                }


                int up = 0;
                int left = 0;

                if(row > 0)
                  up = dp[row - 1][col];
                
                if(col > 0)
                  left = dp[row][col - 1];
                
                dp[row][col] = up + left;
                
            }
        }

        return dp[totRow - 1][totCol - 1];
    }
}