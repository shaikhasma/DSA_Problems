class Cell{
    int row;
    int col;
    public Cell(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
      Queue<Cell> q = new LinkedList<>();
      boolean[][] visited = new boolean[image.length][image[0].length];
      int initColor = image[sr][sc];
      
      //Step 1. push starting cell with row & col to Q Mark it as visited
      q.add(new Cell(sr, sc));
      visited[sr][sc] = true;

      //Step 2 : take cell one by one from Q & color it with new color in image[row][col]
      while(!q.isEmpty()){
          Cell cell = q.remove();
          int row = cell.row;
          int col = cell.col;

          //color with new color in same image
          image[row][col] = color;

        
          int[] dRow = {1, -1, 0 , 0};
          int[] dCol = {0, 0, 1, -1};

          for(int dIndex = 0; dIndex <= 3 ; dIndex++){
              int nRow = row + dRow[dIndex];
              int nCol = col + dCol[dIndex];
            // move in 4 direction if yet cell has not color with new color
            // color it & mark it as visited
              if(nRow >= 0 && nRow < image.length &&
                 nCol >= 0 && nCol < image[0].length &&
                 image[nRow][nCol] == initColor && !visited[nRow][nCol]){
                     q.add(new Cell(nRow, nCol));
                     visited[nRow][nCol] = true;
                 }
          }
      }

      return image;


    } 
}