/* Approach. - Recursion
    M = 3 N = 2

    f(2,1)
    up = f(1, 1) // done 1
        up = f(0, 1) // 0
            f(-1, 1) return 0
        left = f(1, 0) // 1
            up = f(0,0) ==> 1
        
        up + left 0 + 1. => 1

    left = f(2, 0) 
        up = f(1, 0) done 1
        up = f(0,0) => 1
        left = f(2, -1) // 0

 public int uniquePaths(int m, int n) {
      return solv(m - 1, n - 1 );
    }

    int solv(int row, int col){
   
      if(row == 0 && col == 0)
            return 1;
      
      if(row < 0 || col < 0)
            return 0;

      int up = solv(row - 1, col);
      int left = solv(row, col - 1);

      return up + left;    
    }    
TC - 0(2^N*M)
SC - 0(2^N*M)
      stack


Approach. - 2 Recursion + Memoiation 
    - Use dp[row][col] to store all paths to reach each cell
TC - 0(N*M)
SC - 0(N*M) + 0(N*M)
      dp       stack
   - 0(NM)

class Solution {
            Integer[][] dp ;
            public int uniquePaths(int m, int n) {
            this.dp =  new Integer[m][n];
            return solv(m - 1, n - 1);
            }

            int solv(int row, int col){
        
            if(row == 0 && col == 0)
                    return 1;
            
            if(row < 0 || col < 0)
                    return 0;
            
            if(dp[row][col] != null)
                    return dp[row][col];

            int up = solv(row - 1, col);
            int left = solv(row, col - 1);

            return dp[row][col] = up + left;    
            }    
        }       

Approach - 3 Tabulation / Bottom Up Apporach
    - Use d[row][col]
    - Traverse 2d array 0 to M-1
                       0 to N-1 
        - if(row == 0 || col == 0)
            assign dp[row][col] = 1
            continue
        
        To Avoid AIOD / Boundary Check
        - go up when row > 0 
        - go left when col > 0

        - dp[row][col] = up + left;

    return dp[m-n][n-1]
TC- 0(N*M)
SC - 0(N*M)

public int uniquePaths(int m, int n) {
      Integer[][] dp =  new Integer[m][n];
   

      for( int row = 0; row < m ; row++){
        for(int col = 0; col < n; col++){
            if( row == 0 && col == 0){
                dp[row][col] = 1;
                continue;
            }

            int up = 0;
            int left = 0;
            if(row > 0)
                up = dp[row - 1][col];
            if(col > 0 )
                left = dp[row][col - 1];
            
            dp[row][col] = up + left;
        }
      }
      return dp[m-1][n-1];
    }    
*/
class Solution {
   
    public int uniquePaths(int m, int n) {
      Integer[][] dp =  new Integer[m][n];
   

      for( int row = 0; row < m ; row++){
        for(int col = 0; col < n; col++){
            if( row == 0 && col == 0){
                dp[row][col] = 1;
                continue;
            }

            int up = 0;
            int left = 0;
            if(row > 0)
                up = dp[row - 1][col];
            if(col > 0 )
                left = dp[row][col - 1];
            
            dp[row][col] = up + left;
        }
      }
      return dp[m-1][n-1];
    }
}