
/* DFS Traversal = recursion + backtracking ( with extra visiting array not to modify input array)
*/

class Solution {
    
    public int numIslands(char[][] grid) {
     boolean[][] visited = new boolean[grid.length][grid[0].length];

     int isLandCount = 0;

     for(int row = 0; row < grid.length; row++){
        for(int col = 0; col < grid[0].length; col++){
            if(!visited[row][col] && grid[row][col] == '1'){
                isLandCount++;
                dfs(grid, row , col, visited);
            }
        }
     }

     return isLandCount;
    }

    void dfs(char[][] grid, int row, int col, boolean[][] visited){
        
        
       
        if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && 
            !visited[row][col] && grid[row][col] == '1'){
            
            visited[row][col] = true;

            dfs(grid, row , col - 1, visited);
            dfs(grid, row + 1, col, visited);
            dfs(grid, row, col + 1, visited);
            dfs(grid, row - 1, col, visited);
        }
    }
}

/*
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
 */ 