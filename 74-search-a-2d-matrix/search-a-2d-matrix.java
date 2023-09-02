/* 
Search in 2 D Matrix Brute force By Asma 
T.C - 0(NM)
S.C - 0(1)
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       for(int row = 0; row < matrix.length; row++){
           for(int col = 0; col < matrix[0].length; col++){
              if(target == matrix[row][col])
                return true;
           }
       }

       return false;
        
    }        
}