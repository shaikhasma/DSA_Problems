/* Approach - BFS + Q + Cell ( row, col , dist) 
  
  TC - 0 (V + E)
  SC - 0 (V) 
        q
*/
class Cell{
   int row;
   int col;
   int dist;

   public Cell(int row, int col, int dist){
    this.row = row;
    this.col = col;
    this.dist = dist;
   }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
    
        Queue<Cell> q = new LinkedList<>();
        q.add(new Cell(0,0,1));

        while(!q.isEmpty()){
            Cell cell = q.poll();

            int row = cell.row;
            int col = cell.col;
            int dist = cell.dist;

            if(row >= 0 && row < grid.length && col >=0 && col < grid[0].length
                  && grid[row][col] != 1){
                grid[row][col] = 1;

                if(row == grid.length - 1 && col == grid[0].length - 1){
                    return dist;
                }

                q.add( new Cell(row - 1, col, dist + 1));// top
                q.add( new Cell(row - 1, col + 1, dist + 1 )); //right upper diagonal
                q.add( new Cell(row, col + 1, dist + 1)); // right
                q.add( new Cell(row + 1, col + 1, dist + 1 ));  //right lower diagonal
                q.add( new Cell(row + 1, col, dist + 1)); // down
                q.add( new Cell(row + 1, col - 1, dist + 1 )); // left lower diagonal
                q.add( new Cell(row, col - 1, dist + 1)); // left
                q.add( new Cell(row - 1 , col - 1, dist + 1)); // left upper diagonal
            }
        }
         
        return -1;
        
    }
}