/*
["..Q.",
"Q...",
"...Q",
".Q.."
],
["...Q",
"Q...",
"..Q.",
".Q.."
],
[".Q..",
"...Q",
"Q...",
"..Q."
],
["...Q",
".Q..",
"Q...",
"..Q."],

[".Q..",
"...Q",
"..Q.",
"Q..."],
["..Q.",
".Q..",
"...Q",
"Q..."],
["...Q",
"..Q.",
".Q..",
"Q..."
]
*/
class Solution {
    private static final char EMPTY_CELL = '.';
    private static final char QUEEN = 'Q';
    
    public List<List<String>> solveNQueens(int n) {
       List<List<String>> list = new ArrayList<>();
       char[][] board = newBoard(n);

       fillQueen(board, 0, list);

       return list;
    }

    void fillQueen(char[][] board, int col, List<List<String>> list){
        
        if(col == board[0].length){
            list.add(boardToList(board));
            return;
        }

        for( int row = 0 ; row < board.length; row++){
            if(check(board, row, col)){
                board[row][col] = QUEEN;

                fillQueen(board, col + 1, list);

                board[row][col] = EMPTY_CELL;
            }
        }
    }
    
    ArrayList<String> boardToList(char[][] board){
        ArrayList<String> list = new ArrayList<String>();

        for(int index = 0; index < board.length; index++){
            String str = new String(board[index]);
            list.add(str);
        }

        return list;

    }
    boolean check(char[][] board, int row, int col){
        //left check
        int tempRow = row;
        int tempCol = col;

        while(tempCol >= 0){
            if( board[tempRow][tempCol] == QUEEN ) 
                return false;

            tempCol--;
        }

        //top check
        tempRow = row;
        tempCol = col;

        while(tempRow >= 0){
            if( board[tempRow][tempCol] == QUEEN ) 
                return false;

            tempRow--;
        }

        //left uppper Diagonal
        tempRow = row;
        tempCol = col;

        while(tempCol >= 0 && tempRow >= 0){
            if( board[tempRow][tempCol] == QUEEN ) 
                return false;
                
            tempCol--;
            tempRow--;
        }

         //left lower Diagonal
        tempRow = row;
        tempCol = col;

        while(tempCol >= 0 && tempRow < board.length){
            if( board[tempRow][tempCol] == QUEEN ) 
                return false;
            
            tempCol--;
            tempRow++;
        }

        return true;
    }

    char[][] newBoard(int n){
       char[][] board = new char[n][n];
       
       for(int index = 0; index < n; index++){
         Arrays.fill(board[index], EMPTY_CELL);
       }
       
       return board;
    }
}