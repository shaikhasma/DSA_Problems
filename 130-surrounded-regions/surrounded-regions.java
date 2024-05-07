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
     boolean[][] visited = new boolean[board.length][board[0].length];

     for(int index = 0; index < board[0].length; index++){
       //1st row
       if(board[0][index] == 'O' && !visited[0][index]){
          dfs(board, 0, index, visited);
       }

       // last row
       if(board[board.length - 1][index] == 'O' && !visited[board.length - 1][index]){
        dfs(board, board.length - 1, index, visited);
       }
     }

     for(int index = 0; index < board.length; index++){
        // 1st col
        if(board[index][0] =='O' && !visited[index][0]){
            dfs(board, index, 0, visited);
        }


        // last col
         if(board[index][board[0].length - 1 ] == 'O' 
               && !visited[index][board[0].length - 1] ){
            dfs(board,  index, board[0].length - 1, visited);
         }
     }

     // traverse to flip
     for(int row = 0; row < board.length; row++){
        for(int col = 0; col < board[0].length; col++){
            if( board[row][col] == 'O' && !visited[row][col]){
                board[row][col] ='X';
            }
        }
     }   
        
    }

    void dfs(char[][] board, int row, int col, boolean[][] visited){
      

        if(row >= 0  &&  row < board.length && col >= 0 && col < board[0].length &&
            board[row][col] == 'O' && !visited[row][col]){
          visited[row][col] = true;
            dfs(board, row + 1, col, visited);
            dfs(board, row , col - 1, visited);
            dfs(board, row - 1, col, visited);
            dfs(board, row, col + 1, visited);
        }

    }
}