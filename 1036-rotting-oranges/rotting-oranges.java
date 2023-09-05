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
    int[][] visited = new int[grid.length][grid[0].length];
    int freshOrangeCount = 0;
    Queue<Orange> q = new LinkedList<>();

    //step 1 : traverse matrix 
    //          push all rotten orange into Q
    //          mark the rotten orange as visited in visited[][]
    //          count freshOrange

    for(int row = 0; row < grid.length; row++){
        for(int col = 0; col < grid[0].length; col++){
            if(grid[row][col] == 2){
                q.add(new Orange(row, col, 0));
                visited[row][col] = 2;
            }else if(grid[row][col] == 1){
                freshOrangeCount ++;
            }
        }
    }
    
    //Step 2:  take oranges from q one by one 
    //         and rotten all four direction's oranges
    //         push into Q with time + 1
    //         mark in visited[][]
    //         count rotten orange

   int totalTime = 0;
   int rottenOrange = 0;
    while(!q.isEmpty()){
        Orange orange = q.remove();
        int row = orange.row;
        int col = orange.col;
        int time = orange.time;
        totalTime = Math.max(totalTime, time);

        int[] dRow = {1, -1, 0, 0 };
        int[] dCol = {0, 0, 1, -1}; 

        for( int dirIndex = 0 ; dirIndex <=3 ; dirIndex++){
            int nRow = row + dRow[dirIndex];
            int nCol = col + dCol[dirIndex];

            if(nRow >= 0 && nRow < grid.length &&
               nCol >= 0 && nCol < grid[0].length &&
               grid[nRow][nCol] == 1 && visited[nRow][nCol] != 2){
                   q.add(new Orange(nRow, nCol, time + 1));
                   visited[nRow][nCol] = 2;
                   rottenOrange ++;
               }
        }
    }

    if(freshOrangeCount != rottenOrange){
     return  -1;
    }

    return totalTime;

    }
}