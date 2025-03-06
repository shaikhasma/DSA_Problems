class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        int island = 0;
        for( int row = 0; row < n; row++){
            for( int col = 0; col < m ; col++){
                if(grid[row][col] == '1' && !visited[row][col]){
                    island++;
                    dfs(grid, row, col, visited);
                }
            }
        }

        return island;
    }

    void dfs(char[][] grid, int row, int col, boolean[][] visited){
        if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length
          && grid[row][col] == '1' && !visited[row][col]){
            visited[row][col] = true;

            //top
            dfs(grid, row - 1, col, visited);
            //down
            dfs(grid, row + 1, col, visited);
            //left
            dfs(grid, row, col - 1, visited);
            //right
            dfs(grid, row , col + 1, visited);
          }
    }
}