/* 
Search in 2 D Matrix selecting / skiping row/col  By Asma 
T.C - 0(N)
S.C - 0(1)
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       int row = 0;
       int col = matrix[0].length - 1;

       while(row < matrix.length && col >= 0){
           if(matrix[row][col] == target)
              return true;
           
           if( matrix[row][col] > target)
               col--;  
           else if(matrix[row][col] < target)
               row++;
       }

       return false;
    }        
}