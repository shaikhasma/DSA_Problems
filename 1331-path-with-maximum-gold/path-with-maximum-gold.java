class Solution {
    public int getMaximumGold(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int maxGold = 0;

        boolean[][] visited = new boolean[n][m];
        for(int row = 0; row < n; row++){
            for(int col = 0; col < m; col++){
               if(grid[row][col] != 0 && !visited[row][col])
                    maxGold = Math.max(maxGold, dfs(grid, row, col, n, m, visited));
            }
        }

        return maxGold;
    }

    int dfs(int[][] grid, int row, int col, int n, int m, boolean[][] visited){
       // Base condition: Out of bounds, already visited, or zero cell
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || 
            grid[row][col] == 0 || visited[row][col]) {
            return 0;
        }

        visited[row][col] = true;
        
        //left
        int left = grid[row][col] + dfs(grid, row , col - 1, n , m, visited);
        //right
        int right = grid[row][col] + dfs(grid, row , col + 1, n , m, visited);
        //top
        int top = grid[row][col] + dfs(grid, row - 1 , col, n , m, visited);
        //down 
        int down = grid[row][col] + dfs(grid, row + 1 , col, n , m, visited);
              
        //backtrack
        visited[row][col] = false;

        return Math.max(left, Math.max(right, Math.max(top, down)));
    }
}