class Solution {
    public void setZeroes(int[][] matrix) {
      //step 1: traverse matrix and mark ith row matrix[i][0] and ith col matrix[0][col] to zero
                // if row is 0 mark matrix[0][0] but when col is 0 mark isFirstColZero = true

     boolean isFirstColZero = false;
     for(int row = 0; row < matrix.length ; row++){
         for(int col = 0; col < matrix[0].length; col++){
             if(matrix[row][col] == 0){
                 matrix[row][0] = 0;

                 if(col != 0)
                    matrix[0][col] = 0;
                 else
                    isFirstColZero = true;
             }
         }
     }
      //step 2: Will update the matrix start row and col both start from [1][1] to [n][m] except 1st  row & col
               // if 1st row is 0 or 1st col is 0 then mark matrix [i][j] = 0;
      for(int row = 1 ; row < matrix.length; row++){
          for(int col = 1; col < matrix[0].length; col++){

              //if cell is non zero then only will update by zero
              if (matrix[row][col] != 0){
                 if( matrix[row][0] == 0 || matrix[0][col] == 0){
                     matrix[row][col] = 0;
                 }
              }

          }
      }

      //step 3: first mark row 
      if(matrix[0][0] == 0){
          for(int col = 0 ; col < matrix[0].length; col++){
              matrix[0][col] = 0;
          }
      }
     
     //step 4: At last mark col
      if(isFirstColZero == true){
          for(int row = 0 ; row < matrix.length; row++){
              matrix[row][0] = 0;
          }
      }
  }
}