/*
[0,0,0],
[0,1,0],
[1,1,1]

==> q add ( step 0 ) or next --- equal q.add(node.step + 1)
== > poll [0 ] or next [step] 


[0,0,0],
[0,1,0],
[1,2,1]


[1 1 1 0       ]
 */
class Cell{
    int row ;
    int col;
    int step;

    public Cell(int row, int col, int step){
        this.row = row;
        this.col = col;
        this.step = step;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<Cell> q = new LinkedList<Cell>();
        boolean[][] visited = new boolean[n][m];
        int[][] dist = new int[n][m];

        for(int row = 0; row < n; row++){
            for( int col = 0; col < m ; col++){
                if(mat[row][col] == 0){
                    q.add(new Cell(row, col, 0));
                    visited[row][col] = true;
                }
            }
        }

        while(!q.isEmpty()){
            Cell cell = q.poll();
            int row = cell.row;
            int col = cell.col;
            int step = cell.step;

            dist[row][col] = step;

            int[] dRow = {0, -1, 0, 1};
            int[] dCol = {-1, 0, 1 , 0};


            for(int index = 0; index <= 3; index++){
                int newRow = row + dRow[index];
                int newCol = col + dCol[index];

                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && 
                   visited[newRow][newCol] == false){

                   visited[newRow][newCol] = true;
                   q.add(new Cell(newRow, newCol, step + 1));
                }
            }
        }
         
         return dist;
    }
}