class Solution {
    final static char EMPTY = '.';
    final static char QUEEN = 'Q';

    public List<List<String>> solveNQueens(int n) {
        char[][] board = createBoard(n);
        List<List<String>> placements = new ArrayList<>();
        
        //col
        solve(board, 0, placements);
        return placements;
    }

    void solve(char[][] board,int col, List<List<String>> ans){
        //base 
        if(col >= board[0].length){
            ans.add(readBoardPlacements(board));
            return;
        }
        
        for(int row = 0; row < board.length ; row++){
            if(isValidPlace(board, row, col)){
               board[row][col] = QUEEN; //placment
               solve(board, col + 1, ans );
               board[row][col] = EMPTY;//backtrack
            }
        }
    }

    boolean isValidPlace(char[][] board, int row, int col){
      int tempRow = row;
      int tempCol = col;
    
      // left side
      while(tempCol >= 0){
        if(board[tempRow][tempCol] == QUEEN)
            return false;
        tempCol--;
      }
       
       tempRow = row;
       tempCol = col;
      //upper Left diagonal
      while(tempRow >= 0 && tempCol >= 0){
        if(board[tempRow][tempCol] == QUEEN)
            return false;
        tempCol--;
        tempRow--;
      }
      
      // lower Left diagonal
       tempRow = row;
       tempCol = col;
        while(tempRow < board.length && tempCol >= 0){
         if(board[tempRow][tempCol] == QUEEN)
            return false;

        tempCol--;
        tempRow++;
      }

      return true;
    }

    List<String> readBoardPlacements(char[][] board){
        List<String> list = new ArrayList<String>();

     for(int row = 0; row < board.length; row++){
        StringBuilder str = new StringBuilder();
        
        for(int col = 0; col < board[0].length; col++){
          str.append(board[row][col]+"");
        }

        list.add(str.toString());
     }
     return list;
    }

    char[][] createBoard(int n){
        char[][] board = new char[n][n];
        for(int index = 0; index < n; index++){
            Arrays.fill(board[index], EMPTY);
        }

        return board;
    }
}