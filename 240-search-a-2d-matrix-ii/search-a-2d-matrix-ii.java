
/* Binary Search 
TC - 0(log(NM))
SC - 0(1)
*/


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int column = matrix[0].length - 1;

        while(row < matrix.length && column >= 0){
            
            if(matrix[row][column] == target)
                return true;

            if(target < matrix[row][column])
              column--;
            else
              row++;
        }
       return false;
    }
}