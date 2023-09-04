class Solution {
    public void setZeroes(int[][] matrix) {
     // Step 1. Mark in set of row and set of column
     Set<Integer> rowSet = new HashSet<>();
     Set<Integer> colSet = new HashSet<>();
     for(int row = 0; row < matrix.length; row++){
         for(int col = 0 ; col < matrix[0].length ; col++){
            if(matrix[row][col] == 0){
               rowSet.add(row);
               colSet.add(col);
            }
         }
     }

     //Step 2. Traverse matrix and check if set contain current row or column, 
     //         if contains make cell = 0
     for(int row = 0; row < matrix.length; row++){
         for(int col = 0 ; col < matrix[0].length ; col++){
            if(matrix[row][col] != 0){
                if(rowSet.contains(row) || colSet.contains(col)){
                    matrix[row][col] = 0;
                }
            }
         }
     }

    }
}