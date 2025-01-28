class Solution {
   public int findMaxFish(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    int maxFish = 0; 
    // variable to store the maximum number of fish caught
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
             // if the current cell contains fish
            if(grid[i][j] > 0) {       
                maxFish = Math.max(maxFish, dfs(i, j, grid, n, m)); 
                // update the maximum number of fish caught
            }
        }
    }
    // return the maximum number of fish caught
    return maxFish; 
}

// array to store the four possible directions
private final int[] dr = {0, 1, 0, -1, 0};

// function to perform DFS and count the number of fish caught
int dfs(int i, int j, int[][] grid, int n, int m) {
    // count the number of fish caught in the current cell
    int fish = grid[i][j]; 
    // mark the current cell as visited by setting its value to 0
    grid[i][j] = 0; 
    // iterate over the four possible directions
    for(int k = 0; k < 4; k++) { 
        // calculate the coordinates of the adjacent cell
        int nr = i + dr[k];
        int nc = j + dr[k + 1]; 
        if(nr < n && nr >= 0 &&  nc < m && nc >= 0 
             && grid[nr][nc] > 0) { 
        // if the adjacent cell contains fish and is within the grid
            fish += dfs(nr, nc, grid, n, m); // count the number of fish caught in the adjacent cell
        }
    }
    return fish; // return the total number of fish caught
}
}