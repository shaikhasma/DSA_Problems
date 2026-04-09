/* Appraoch - 1 Normal 2D traversal search
TC = 0(NM)
SC : 0(1)

Appraoch- 2 Decide Row or Col traversal based on target value (Using properify of sorting row and col)
TC : 0(max(n,m))
SC : 0(1)

*/
class Solution {
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
}