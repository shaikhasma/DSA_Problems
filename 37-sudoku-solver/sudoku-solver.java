class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    boolean solve(char[][] grid){
        for(int row = 0; row < grid.length ; row++){
            for(int col = 0; col < grid[0].length ; col++){
                //1. find empty cell
                if(grid[row][col] == '.'){
                    //try all possiblities
                    for(char ch = '1' ; ch <='9'; ch++){
                        if(validPlace(grid, row, col, ch)){
                            //place
                            grid[row][col] = ch;
                            //explore
                            if(solve(grid))
                                return true;

                            grid[row][col] ='.';
                        }
                    }
                    return false;
                }
           }
        }

        return true;
    }

    boolean validPlace(char[][] grid, int row, int col, char ch){
     for(int index = 0; index <= 8 ; index++){
        if(grid[row][index] == ch || grid[index][col] == ch)
          return false;

        int subRow = 3 * (row / 3 ) + ( index / 3);  // row = 2 col = 3
        int subCol =  3 * (col / 3 ) + (index % 3);
    
        if(grid[subRow][subCol] == ch)
            return false;
      
    }

    return true;
    }
}
