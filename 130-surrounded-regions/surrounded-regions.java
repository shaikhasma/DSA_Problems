/*

["X","X","X","X"],  [- - - - ]
["X","O","O","X"],  [- - - - ]
["X","X","O","X"],  [- - - - ]
["X","O","X","X"].  [- T - - ]


["X","X","X","X"],
["X","X","X","X"],
["X","X","X","X"],
["X","X","X","X"]
*/
class Solution {
    public void solve(char[][] board) {
     int n = board.length;
     int m = board[0].length;

     int firstRow = 0;
     int firstCol = 0;
     int lastRow = n - 1;
     int lastCol = m - 1;
     
     boolean[][] visited = new boolean[board.length][board[0].length];
     
     //1st Row
     for(int col = 0 ; col < m ; col++){
        if(board[firstRow][col] == 'O' && !visited[firstRow][col]){
            visited[firstRow][col] = true;
            dfs(board, firstRow, col, visited);
        }
     }

     //Last Row
     for(int col = 0 ; col < m ; col++){
        if(board[lastRow][col] == 'O' && !visited[lastRow][col]){
            visited[lastRow][col] = true;
            dfs(board, lastRow, col, visited);
        }
     }

     //1st col
     for(int row = 0 ; row < n ; row++){
        if(board[row][firstCol] == 'O' && !visited[row][firstCol]){
            visited[row][firstCol] = true;
            dfs(board, row, firstCol, visited);
        }
     }

        //last col
        for(int row = 0 ; row < n ; row++){
            if(board[row][lastCol] == 'O' && !visited[row][lastCol]){
                visited[row][lastCol] = true;
                dfs(board, row, lastCol, visited);
            }
        } 

      //flip
        for(int row = 0 ; row < n ; row++){
            for(int col = 0; col < m ; col++){
                if(board[row][col] == 'O' && !visited[row][col])
                    board[row][col] = 'X';
            }
        }

    }

    void dfs(char[][] board, int row, int col, boolean[][] visited){
        visited[row][col] = true;
            
        // L ,T, R, D
        int[] dRow = {0, -1, 0, 1};
        int[] dCol = {-1, 0, 1, 0};
        for(int index = 0; index <= 3; index++){
            int nRow = row + dRow[index];
            int nCol = col + dCol[index];

            if(nRow >= 0 && nRow < board.length && nCol >= 0 && nCol < board[0].length && 
                board[nRow][nCol] == 'O' && !visited[nRow][nCol])
                dfs(board, nRow, nCol, visited);
        }
    }

}