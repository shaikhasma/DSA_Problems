/* 
Search in 2 D Matrix selecting / skiping row/col  By Asma 
T.C - 0(N)
S.C - 0(1)
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       int totalRow = matrix.length;
       int totalCol = matrix[0].length;
       int low = 0;
       int high = totalRow * totalCol - 1;

       while(low <= high){
           int mid = low + ( high - low) / 2;

           int row = mid / totalCol; 
           int col = mid % totalCol;

           if(matrix[row][col] == target){
               return true;
           }
           if(matrix[row][col] < target){
               low = mid + 1;
           }else{
               high = mid - 1;
           }
       }

       return false;
    }        
}