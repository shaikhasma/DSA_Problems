class Solution {
    public void setZeroes(int[][] matrix) {
     // Step 1. Mark in set of row and set of column
     int[] rowSet = new int[matrix.length];
    int[] colSet = new  int[matrix[0].length];
     for(int row = 0; row < matrix.length; row++){
         for(int col = 0 ; col < matrix[0].length ; col++){
            if(matrix[row][col] == 0){
               rowSet[row] = 1;
               colSet[col] = 1;
            }
         }
     }

     //Step 2. Traverse matrix and check if set contain current row or column, 
     //         if contains make cell = 0
     for(int row = 0; row < matrix.length; row++){
         for(int col = 0 ; col < matrix[0].length ; col++){
            if(matrix[row][col] != 0){
                if(rowSet[row] == 1 || colSet[col] == 1){
                    matrix[row][col] = 0;
                }
            }
         }
     }

    }
}