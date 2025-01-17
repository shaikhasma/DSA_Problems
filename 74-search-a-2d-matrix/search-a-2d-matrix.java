/* approach - 2
- first row last col element < target
   find in same row
- first row last col element > target
   find in next row

public boolean searchMatrix(int[][] matrix, int target) {
        int col = matrix[0].length - 1; 
        int row = 0;
        while(col >= 0 && row <= matrix.length - 1){
           if(target == matrix[row][col])
                return true;
           else if(target < matrix[row][col] )
               col--;
           else 
              row++;
        }

        return false;
    }
TC - 0(N) worst case either  row or  column need to traverse

Approach - 3 cansider single sorted array + binary search
Tot size = row & col
low = 0 high = totSize - 1;
middle = low + (high - 1) / 2
get row = middle / column
get col = middle % col

public boolean searchMatrix(int[][] matrix, int target) {
        
       int n = matrix.length ;
       int m = matrix[0].length;

       int low = 0;
       int high = (n * m) - 1;

       while(low <= high){
        
        int mid = low + ( high - low ) / 2;
        int row = mid / m;
        int col = mid % m;

        if(target == matrix[row][col])
            return true;
        else if(target < matrix[row][col])
             high = mid - 1;
        else
             low = mid + 1;
       }
       return false;
    }

    TC - 0(log MN)
    SC - 0(1)
 
*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
       int n = matrix.length ;
       int m = matrix[0].length;

       int low = 0;
       int high = (n * m) - 1;

       while(low <= high){
        
        int mid = low + ( high - low ) / 2;
        int row = mid / m;
        int col = mid % m;

        if(target == matrix[row][col])
            return true;
        else if(target < matrix[row][col])
             high = mid - 1;
        else
             low = mid + 1;
       }
       return false;
    }
}