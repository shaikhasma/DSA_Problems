/*
 TC - 0(4 * NM)
 SC - 0(NM) stack space
*/
class Solution {
    public int getMaximumGold(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m]; // Marking array
        int maxGold = 0;
        
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] != 0) {
                    maxGold = Math.max(maxGold, dfs(grid, row, col, visited));
                }
            }
        }
        return maxGold;
    }
    
    private int dfs(int[][] grid, int row, int col, boolean[][] visited) {
        // Base condition: Out of bounds, already visited, or zero cell
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || 
            grid[row][col] == 0 || visited[row][col]) {
            return 0;
        }

        // Mark current cell as visited
        visited[row][col] = true;

        // Move in all four directions and collect max gold
        int left = dfs(grid, row, col - 1, visited);
        int right = dfs(grid, row, col + 1, visited);
        int up = dfs(grid, row - 1, col, visited);
        int down = dfs(grid, row + 1, col, visited);

        // Backtrack (unmark the cell)
        visited[row][col] = false;

        // Return the max gold collected including the current cell
        return grid[row][col] + Math.max(Math.max(left, right), Math.max(up, down));
    }
}
