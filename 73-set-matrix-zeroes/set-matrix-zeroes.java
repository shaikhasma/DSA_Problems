class Solution {
    public void setZeroes(int[][] matrix) {
    //Step 1. Traverse matrix & mark ith row & ith col as zero if we found any cell 0
    //.       If first row is zero mark [0][0] 
    //        if first col is zero mark isFirstColZero = true
    boolean isFirstCol = false;
    for(int row = 0; row < matrix.length ; row++){
        for(int col = 0; col < matrix[0].length; col++){
            if(matrix[row][col] == 0){
                matrix[row][0]= 0;

                if(col != 0){
                    matrix[0][col] = 0;
                }else{
                    isFirstCol = true;
                }
            }
        }
    }
    //Step 2. Traverse matrix from [1][1] to [matrix.length][matrix[0].length]
    //.       if 1st Row or 1t col is zero then  Mark cell = 0 
    for(int row = 1; row < matrix.length; row++){
        for(int col = 1; col < matrix[0].length; col++){
            if(matrix[row][col] != 0){
                if(matrix[row][0] == 0 || matrix[0][col] == 0){
                    matrix[row][col] = 0;
                }
            }
        }
    }
    //Step 3. First update Row as zero if [0][0] is 0
    if(matrix[0][0] == 0){
        for(int col = 0; col < matrix[0].length; col++){
            matrix[0][col] = 0;
        }
    }
    //Step 4 At last update col as zero if isFirstCol = 0
    if(isFirstCol == true){
        for(int row = 0 ; row < matrix.length; row++){
            matrix[row][0] = 0;
        }
    }

    }
}