/** Striver SDE Sheet Challenge By Asma Shaikh 
    linkedin.com/in/asma-shaikh-411137b1
    Rotate Image by 90 degree
 */
class Solution {
    public void rotate(int[][] matrix) {
        //Step 1. Transpose row to column
         transposeRowToCol(matrix);
 
        //Step 2. Reverse rows
        reverseRow(matrix);
    }

   private void transposeRowToCol(int[][] matrix ){
       for(int row = 0; row < matrix.length; row++){
          for(int col = row + 1; col < matrix[0].length; col++){
              int temp = matrix[row][col];
              matrix[row][col] = matrix[col][row];
              matrix[col][row] = temp;
          }
       }
   }

  private void reverseRow(int[][] matrix){
      for(int row = 0 ; row < matrix.length; row++){
         for( int col = 0 ; col < matrix.length / 2; col++){
            int temp = matrix[row][col];
            matrix[row][col] = matrix[row][matrix[0].length - 1 - col];
            matrix[row][matrix.length - 1 - col] = temp;
         }
      }
  }
}

/**
TC :
    (N * N)    + (N * N)
    Transpose.   Reverse
    0(N * N)

SC : 0(1) As we are doing in place

 */


 