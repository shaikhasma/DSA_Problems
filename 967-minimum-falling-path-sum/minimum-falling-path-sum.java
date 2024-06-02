/*
Approach - 1 Recursion
TC - 0(3^N) exploring n row for 3 different options
SC - 0(N)

Program - 
    public int minFallingPathSum(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int minSum = Integer.MAX_VALUE;

        for(int index = 0; index < col; index++){
            int ans = solv(matrix, row - 1, index);
            minSum = Math.min(minSum, ans);
        }

        return minSum;    
    }

    int solv(int[][] matrix, int row, int col){
        if( col < 0 || col >= matrix[0].length)
            return (int) 1e9; //invalid path

        if(row == 0)
            return matrix[row][col];

        int up = matrix[row][col] + solv(matrix, row - 1, col);
        int leftDiagonal = matrix[row][col] + solv(matrix, row - 1, col - 1);
        int rightDiagonal = matrix[row][col] + solv(matrix, row - 1, col + 1);

        return Math.min(up, Math.min(leftDiagonal, rightDiagonal));
    }

Approach - 2 Recursion + Memoiation 
TC - 0(NM)
SC - 0(N) + 0(NM)
    stack.   dp

Program - 
    public int minFallingPathSum(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int minSum = Integer.MAX_VALUE;

        int[][] dp = new int[row][col];
        for( int[] dpRow : dp)
            Arrays.fill(dpRow, -1);
       
        for(int index = 0; index < col; index++){ 
            int ans = solv(matrix, dp, row - 1, index);
            minSum = Math.min(minSum, ans);
        }

        return minSum;    
    }

    int solv(int[][] matrix, int[][] dp, int row, int col){
        if( col < 0 || col >= matrix[0].length)
            return (int) 1e9; //invalid path

        if(row == 0){
            return matrix[0][col];
        }
        
        if(dp[row][col] != -1)
            return dp[row][col];

        int up = matrix[row][col] + solv(matrix,dp, row - 1, col);
        int leftDiagonal = matrix[row][col] + solv(matrix, dp, row - 1, col - 1);
        int rightDiagonal = matrix[row][col] + solv(matrix, dp, row - 1, col + 1);

        return dp[row][col] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));
    }

Approach - 2 Tabulation / Bottom Up
TC - 0(NM)
SC - 0(NM)
    stack.   dp

Program - 
    public int minFallingPathSum(int[][] matrix) {
        int totRow = matrix.length;
        int totCol = matrix[0].length;
        int minSum = Integer.MAX_VALUE;

        int[][] dp = new int[totRow][totCol];
        for( int[] dpRow : dp)
            Arrays.fill(dpRow, -1);
        
        //keep 0th row of matrix into DP[0][col]
        for(int col = 0 ; col < totCol; col++)
            dp[0][col] = matrix[0][col];
        
        for(int row = 1; row < totRow; row++){ 
            for(int col = 0; col < totCol; col++){
            
                int up = matrix[row][col] + dp[row - 1][col];
                int leftDiagonal = matrix[row][col];
                int rightDiagonal = matrix[row][col];

                if( col > 0)
                    leftDiagonal += dp[row - 1][col - 1];
                else 
                    leftDiagonal += (int) 1e9;

                if( col < matrix[0].length - 1)
                    rightDiagonal += dp[row - 1][col + 1];
                 else 
                    rightDiagonal += (int) 1e9;

                dp[row][col] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));
            }
        }

        for(int col = 0; col < totCol; col++){
            minSum = Math.min(minSum, dp[totRow - 1][col]);
        }
        return minSum;    
    }

*/

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int totRow = matrix.length;
        int totCol = matrix[0].length;
        int minSum = Integer.MAX_VALUE;

        int[][] dp = new int[totRow][totCol];
        for( int[] dpRow : dp)
            Arrays.fill(dpRow, -1);
        
        //keep 0th row of matrix into DP[0][col]
        for(int col = 0 ; col < totCol; col++)
            dp[0][col] = matrix[0][col];
        
        for(int row = 1; row < totRow; row++){ 
            for(int col = 0; col < totCol; col++){
            
                int up = matrix[row][col] + dp[row - 1][col];
                int leftDiagonal = matrix[row][col];
                int rightDiagonal = matrix[row][col];

                if( col > 0)
                    leftDiagonal += dp[row - 1][col - 1];
                else 
                    leftDiagonal += (int) 1e9;

                if( col < matrix[0].length - 1)
                    rightDiagonal += dp[row - 1][col + 1];
                 else 
                    rightDiagonal += (int) 1e9;

                dp[row][col] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));
            }
        }

        for(int col = 0; col < totCol; col++){
            minSum = Math.min(minSum, dp[totRow - 1][col]);
        }
        return minSum;    
    }
}
