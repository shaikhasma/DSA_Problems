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
class Node{
    int row;
    int col;
    public Node (int row, int col){
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public void solve(char[][] board) {
     int n = board.length;
     int m = board[0].length;

     int firstRow = 0;
     int firstCol = 0;
     int lastRow = n - 1;
     int lastCol = m - 1; 

     boolean[][] visited = new boolean[board.length][board[0].length];

     Queue<Node> q = new LinkedList<>();
     //1st row
     for(int index = 0; index < m; index++){
        if(board[firstRow][index] =='O' && !visited[firstRow][index]){
            q.add(new Node(firstRow,index));
            visited[firstRow][index] = true;
        }
     }

     //last row
     for(int index = 0; index < m ; index++){
         if(board[lastRow][index] =='O' && !visited[lastRow][index]){
            q.add(new Node(lastRow,index));
            visited[lastRow][index] = true;
         }
     }

     //1st Col
     for(int index = 0; index < n; index++){
         if(board[index][firstCol] =='O' && !visited[index][firstCol]){
            q.add(new Node(index,firstCol));
            visited[index][firstCol] = true;
         }
     }

     //last col
     for(int index = 0; index < n; index++){
         if(board[index][lastCol] =='O' && !visited[index][lastCol]){
            q.add(new Node(index,lastCol));
            visited[index][lastCol] = true;
         }
     }


    int[] dRow = {-1, 0 , 1, 0};
    int[] dCol = {0, 1, 0 , -1};

     while(!q.isEmpty()){
        Node node = q.poll();
        int row = node.row;
        int col = node.col;
      
        for( int index = 0; index < 4; index++){
           int nRow = row + dRow[index];
           int nCol = col + dCol[index];

           if(nRow >= 0 && nRow < n && nCol >=0 && nCol < m &&
                !visited[nRow][nCol] && board[nRow][nCol] == 'O'){
                q.add(new Node(nRow, nCol));
                visited[nRow][nCol] = true;
                }
        }
     }

     for(int row = 0; row < n; row++){
        for(int col = 0; col < m; col++){
            if(board[row][col] == 'O' && visited[row][col] == false){
                board[row][col] = 'X';
            } 
        }
     }

    }
}