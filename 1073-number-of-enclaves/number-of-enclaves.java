/* approach - DFS
1. traverse all boundary lands (1's')
    - call dfs for that
    - mark it as visited
    - it should be land  + it should not visited + it should be valid to call next connected cell

2. traverse complete land 
  - check land which is not visited
  - count it

  TC - 0(N * M * 4) + 0(NM)  = 0(2 * NM) = 0(NM)
  SC - 0(NM)  + 0(NM)
        visited   stack auxillary

  [0,0,0,0],
  [1,0,1,0],
  [0,1,1,0],
  [0,0,0,0]
    
*/
class Solution {
    public int numEnclaves(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(row == 0 || row == grid.length - 1 || col == 0 || col == grid[0].length - 1){

                    if(!visited[row][col] &&  grid[row][col] == 1){
                        dfs(grid, row, col, visited);
                    }
                }
            }
        }
        
        int enclaves = 0;
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if( grid[row][col] == 1 && !visited[row][col]){
                    enclaves++;
                }
            }
        }

        return enclaves;
    }

    void dfs(int[][] grid, int row, int col, boolean[][] visited){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col] || grid[row][col] == 0)
            return;

        visited[row][col] = true;
        
        dfs(grid, row + 1, col, visited);
        dfs(grid, row - 1, col, visited);
        dfs(grid, row, col - 1, visited);
        dfs(grid, row, col + 1, visited);
    }
}