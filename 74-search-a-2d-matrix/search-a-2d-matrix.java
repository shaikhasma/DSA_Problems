/* Appraoch - 1 Normal 2D traversal search
TC = 0(NM)
SC : 0(1)

Appraoch- 2 Decide Row or Col traversal based on target value (Using properify of sorting row and col)
TC : 0(max(n,m))
SC : 0(1)
    public boolean searchMatrix(int[][] matrix, int target) {
      int row = 0;
      int col = matrix[0].length - 1;

      while( row <= matrix.length - 1 && col >= 0){
        if(matrix[row][col] == target)
            return true;
        
        if(matrix[row][col] < target)
            row++;
        else
            col--;    
        
      }        
      return false;
    }

Approach - 3 Binary Search


*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
      int N = matrix.length;
      int M = matrix[0].length; 

      int low = 0;
      int high = (N * M ) - 1;

      while(low <= high){
        int mid = low + (high - low) / 2;
        int row = mid / M;
        int col = mid % M;
        if(matrix[row][col] == target)
            return true;
        
        if(matrix[row][col] < target)
            low = mid + 1;
        else 
            high = mid - 1;
      }
      return false;
    }
}