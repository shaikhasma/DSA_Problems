class Solution {
    int max = 0;
    public int getMaximumGold(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int row = 0; row < n; row++) {
            for(int col = 0; col < m; col++) {
                if(grid[row][col] != 0) {
                    dfs(grid, row, col, 0);
                }
            }
        }
        return max;
    }
    
    private void dfs(int[][] grid, int row, int col, int current) {
        if(row < 0 ||row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
            max = Math.max(max, current);
            return;
        }

        int val = grid[row][col];
        grid[row][col] = 0;

        dfs(grid, row + 1, col, current + val);
        dfs(grid, row - 1, col, current + val);
        dfs(grid, row, col + 1, current + val);
        dfs(grid, row, col - 1, current + val);

        grid[row][col] = val;
    }
}