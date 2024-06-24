class Orange{
    int row;
    int col;
    int time;
    public Orange(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;

    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
     boolean[][] visited = new boolean[grid.length][grid[0].length];
     Queue<Orange> q = new LinkedList<>();
     int freshOrange = 0;
     //Step 1- Add all rottan orange into Q mark it as visited
    //         & maintain fresh orange count
     for(int row = 0; row < grid.length; row ++){
         for(int col = 0; col < grid[0].length; col++){
             if(grid[row][col] == 2){
                 visited[row][col] = true;
                 q.add(new Orange(row,col,0));
             }
             else if(grid[row][col] == 1){
                 freshOrange++;
             }
         }
     }

     //Step 2 : BFS for remaning orange count newly rotten orange
     //         & maintain max time
     int maxTime = 0;
     int rottenCount = 0;
     while(!q.isEmpty()){
         Orange orange = q.poll();
         int r = orange.row;
         int c = orange.col;
         int t = orange.time;
         maxTime = Math.max(maxTime, t);

         // checking four direction fresh non visited orange and pushing into Q
         int[] dRow = {0, -1, 0, 1};
         int[] dCol = {-1, 0, 1, 0};

         for(int index = 0; index <= 3; index++){
             int row = r + dRow[index];
             int col = c + dCol[index];

             if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length &&
                visited[row][col] == false && grid[row][col] == 1){
                    visited[row][col] = true;
                    q.add(new Orange(row, col, t + 1));
                    rottenCount ++;
                }
         }
     }

     if(freshOrange != rottenCount){
         return -1;
     }

     return maxTime;
    }
}