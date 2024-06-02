class Solution {
    private final char EMPTY_CELL = '.';

    public void solveSudoku(char[][] board) {
        solve(board);
    }
    boolean solve(char[][] grid){
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == EMPTY_CELL){
                    //try all 1-9 characters
                    for(char ch = '1'; ch <= '9' ; ch++){
                        if(valid(grid, row, col,ch)){
                            grid[row][col] = ch;
                            
                            if(solve(grid))
                                return true;
                            //backtract if not able fill all empty cell
                            grid[row][col] = EMPTY_CELL;   
                        }
                    }//for end
                    return false;
                }
            }
        }
     return true;
    }

    //check
    boolean valid(char[][] grid, int row, int col, char ch){
      for(int index = 0; index <= 8; index++){
        if(grid[row][index] == ch || grid[index][col] == ch)
            return false;
        
        int subGridRow = 3 * (row / 3) + (index / 3);
        int subGridCol = 3 * (col / 3) + (index % 3);

        if(grid[subGridRow][subGridCol] == ch)
            return false;
      }

      return true;
    }
}