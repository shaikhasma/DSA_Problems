
/* BFS Traversal 
1. Create Node ( row , column), create visited 2d Array
2. call bfs for unvisited node which has 1 marking
3. count the new island has been started count++
4. BFS 
- mark node as visited push into Q
- traverse Q till it is not empty
- take out element from Q retreve row & col
- create dirRow[1,-1,0,0] & dirCol[0,0,1,-1]
- traverse 0 to 3 for all 4 direction 
- calculate new movment nrow = row + dirRow[index] ncol = col + dirCol[index];
- check the new row and column boundary are valid or not
- if we are in valid boundary + node has 1 value. + unvisited node
- mark node as visited & push into q 
*/

class Node{
    int row;
    int col;
    public Node(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    
    public int numIslands(char[][] grid) {
     boolean[][] visited = new boolean[grid.length][grid[0].length];

     int isLandCount = 0;

     for(int row = 0; row < grid.length; row++){
        for(int col = 0; col < grid[0].length; col++){

            if(!visited[row][col] && grid[row][col] == '1'){
                
                isLandCount++;
                bfs(grid, row, col, visited);
            }

        }
     }

     return isLandCount;
    }
    
  //BFS traversal for 4 direction
  private void bfs(char[][] grid, int row, int col, boolean[][] visited) {
      

      Queue<Node> q = new LinkedList<>();
      q.add(new Node(row,col));
      visited[row][col] = true;

      

      while(!q.isEmpty()){
        Node node = q.poll();
        
        int[] dRow = {0, 1, 0, -1};
        int[] dCol = {-1, 0, 1,0};
        
        for(int index = 0; index < 4; index++ ){
            int nRow  = node.row + dRow[index];
            int nCol  = node.col + dCol[index];

            if(nRow >= 0 && nRow < grid.length && nCol >= 0 && nCol < grid[0].length &&
               !visited[nRow][nCol] && grid[nRow][nCol] == '1'){
                   visited[nRow][nCol] = true;
                   q.add(new Node(nRow, nCol));
            }
        }
      }
   }

  
}

/*
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
 */ 