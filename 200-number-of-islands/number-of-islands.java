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
    private int nodeRow;
    private int nodeCol;
    public Node(int nodeRow, int nodeCol){
        this.nodeRow = nodeRow;
        this.nodeCol = nodeCol;
    }

    public int getNodeRow(){
        return nodeRow;
    }

    public int getNodeCol(){
        return nodeCol;
    }
}
class Solution {
    
    public int numIslands(char[][] grid) {
    int[][] visited = new int[grid.length][grid[0].length];
    int island = 0;

    for(int row = 0; row < grid.length; row++){
        for(int col = 0; col < grid[0].length; col++){
            if(grid[row][col] == '1' && visited[row][col] == 0){
                island++;
                bfs(grid, row, col, visited);
            }
        }
    }
    return island;
    }
    
  //BFS traversal for 4 direction
  private void bfs(char[][] grid, int row, int col, int[][] visited) {
      Queue<Node>   q = new LinkedList<>();
      visited[row][col] = 1;
      q.add(new Node(row,col));

     while(!q.isEmpty()){
         Node temp = q.remove();

         int[] dirRow = {1, -1, 0, 0};
         int[] dirCol = {0, 0, 1, -1};

         for(int index = 0; index <= 3; index++){
             int nRow = temp.getNodeRow() + dirRow[index];
             int nCol = temp.getNodeCol() + dirCol[index];

            if(boundaryCheck(nRow, nCol, grid.length, grid[0].length) && 
               grid[nRow][nCol] == '1' && visited[nRow][nCol] == 0){
                   visited[nRow][nCol] = 1;
                   q.add(new Node(nRow, nCol));
               }
         }
     }
   }

   private boolean boundaryCheck(int row, int col, int N, int C){
       return row >= 0 && row <= N - 1 && col >=0 && col <=C - 1 ;
   }

}

/*
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
 */ 