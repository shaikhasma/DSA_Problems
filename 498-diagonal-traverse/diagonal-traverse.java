/* Approach 1 LTR ( row--, col++) RTL ( row++ , col--) manage corner case

TC- 0(M*N)
SC- 0(1)

*/

class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        boolean isLeftToRight = true;
        int[] list = new int[matrix.length * matrix[0].length];
        int index = 0;
       
        int row= 0;
        int col = 0;
   
       while(row < matrix.length && col< matrix[0].length){
             
           if(isLeftToRight){
                while(row > 0 && col < matrix[0].length - 1){
                    list[index++] = matrix[row][col];
                    row--;
                    col++;
                }
               //print last element
               list[index++] = matrix[row][col];
               //manage last corner case
               if (col == matrix[0].length - 1) 
                   row++;
                else 
                   col++;
            
           }else{
               while(row < matrix.length - 1 && col > 0 ){
                    list[index++] = matrix[row][col];
                    row++;
                    col--;
               }
               //print last element
               list[index++] = matrix[row][col];
               //manage last corner case
               if(row == matrix.length - 1) 
                   col++ ;
               else 
                   row++;
          }
          
          isLeftToRight = !isLeftToRight;
         
       }
       return list;
    }
}        

