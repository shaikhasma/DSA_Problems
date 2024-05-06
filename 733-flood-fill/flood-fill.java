
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
     
        int initialColor = image[sr][sc];

        if(initialColor != color)
          dfs(image, sr, sc, initialColor, color);

        return image;
    }

    void dfs(int[][] image, int row, int col, int color , int newColor){
        
        if(row < 0 || row >= image.length || col < 0 || col >= image[0].length || image[row][col] != color)
            return;

            image[row][col] = newColor;


            dfs(image, row , col - 1, color, newColor);
            dfs(image, row + 1, col, color, newColor);
            dfs(image, row, col + 1, color, newColor);
            dfs(image, row - 1, col, color, newColor);
    }

}