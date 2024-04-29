class Solution {
    public void solveSudoku(char[][] board) {
     sodukoSolver(board);
    }

    boolean sodukoSolver(char[][] board){
        for(int row = 0 ; row < board.length; row++){
            for(int col = 0; col < board[0].length; col++){
                
                if(board[row][col] == '.'){
                
                    for(char ch = '1'; ch <= '9'; ch++){
                            if(validCharacter(board, row, col, ch)){
                        
                                board[row][col] = ch;
                                
                                if(sodukoSolver(board))
                                  return true;
                                else
                                    board[row][col] ='.'; //go back try other character

                            }
                    }

                    return false;
                }
            }
       }
       return true;
    }
    
    boolean validCharacter(char[][] board, int row, int col, char ch){
        for(int index = 0; index <= 8; index++){
            // check row contain same character or  not
            // check col contain same character or not
            if(board[row][index] == ch || board[index][col] == ch)
                return false;

            // check same 3* 3 grid has that character or not
            int currentGridRow = 3 * (row/3) + (index / 3);
            int currentGridCol = 3 * (col/3) + (index % 3);

            if(board[currentGridRow][currentGridCol] == ch)
              return false;
    
        }
        return true;
    }
    
}