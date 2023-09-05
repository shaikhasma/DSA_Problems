
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
      int currentColor = image[sr][sc];

     if(currentColor != color) 
         dfs(image, sr, sc, currentColor, color );

      return image;
    } 

    void dfs(int[][] image, int row, int col, int currentColor, int newColor){
     if(row < 0 || row >= image.length || col < 0 || 
        col >= image[0].length || image[row][col] != currentColor)
            return;
         
        image[row][col] = newColor;

        dfs(image, row + 1, col, currentColor, newColor);
        dfs(image, row - 1, col, currentColor, newColor);
        dfs(image, row, col + 1 , currentColor, newColor);
        dfs(image, row, col - 1, currentColor, newColor);
      }
}