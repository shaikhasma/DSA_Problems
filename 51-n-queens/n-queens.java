class Solution {
    final static char EMPTY_CELL='.';
    final static char QUEEN_CELL='Q';

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();    
        char[][] board = createNewBoard(n);

        solve(board, 0, ans);

        return ans;
    }

    void solve(char[][] board, int column, List<List<String>> ans){

        if(column == board[0].length){
            ans.add(queenPlacements(board));
            return;
        }

        for(int row = 0; row < board.length; row++){

            if(possibleQueenPlacment(board, row, column)){
                 
                 board[row][column] = QUEEN_CELL;

                //go for next queen placement
                   solve(board, column + 1, ans);
                    
                //backtrack if not possible to place
                   board[row][column] = EMPTY_CELL;
            }
        }

    }

    boolean possibleQueenPlacment(char[][] board, int row, int col){
        // check upper left daigonal
        int tempRow = row;
        int tempCol = col;
        while(tempRow >= 0 && tempCol >=0){
            
            if(board[tempRow][tempCol] == QUEEN_CELL)
              return false;
              
              tempRow--;
              tempCol--;
        }
         
        // check left side
        tempRow = row;
        tempCol = col;
        
        while(tempCol >= 0){
            
            if(board[tempRow][tempCol] == QUEEN_CELL)
              return false;
            
            tempCol--;
        }

        // check lower left daigonal
        tempRow = row;
        tempCol = col;
        while(tempRow < board.length && tempCol >= 0){

            if(board[tempRow][tempCol] == QUEEN_CELL)
                return false;
            
            tempRow++;
            tempCol--;
        }

        return true;

    }

    char[][] createNewBoard(int n){
        char[][] board = new char[n][n]; 
        
        for(int row = 0; row < n; row++){
            Arrays.fill(board[row], EMPTY_CELL);
        }

        return board;
    }

    List<String> queenPlacements(char[][] board){
        List<String> list = new ArrayList<String>();
        
        for(int index = 0; index < board.length; index++){
            String str = new String(board[index]);
            list.add(str);
        }

        return list;
    }

    
}