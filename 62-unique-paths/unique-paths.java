/* Approach. - Recursion. + Memoiation
 f(0,0 )

f(i,j ) = down  + right
        down - f(i + 1, j)
        right - f(i, j + 1)

base i == m - 1 && j == n-1
          reutrn 1
negative m - 1 || n - 1
          return 0;

m = 3, n = 2. 0 1 2
f(0,0 ) = 
        right - 1
             right - 0
            
                        
        down - f(1, 0)

TC - 0(N*M)
SC - 0(N*M)
*/
class Solution {
    Integer[][] dp ;
    public int uniquePaths(int m, int n) {
        dp = new Integer[m][n];
        return solv(0, 0, m , n);
    }

    int solv(int row, int col, int rowSize, int colSize){

        if(row == rowSize - 1 && col == colSize - 1)
            return 1;
        
        if(row == rowSize || col == colSize)
            return 0;
        
        if(dp[row][col] != null)
            return dp[row][col];

        int right = solv(row, col + 1, rowSize, colSize);
        int down = solv(row + 1, col, rowSize, colSize);

        return dp[row][col] = right + down;
    }
}