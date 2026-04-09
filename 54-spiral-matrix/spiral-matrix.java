class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
      int firstRow = 0;
      int lastCol = matrix[0].length - 1;
      int lastRow = matrix.length - 1;    
      int firstCol = 0;
      List<Integer> list = new ArrayList<>();
      int N = matrix.length * matrix[0].length;

      while(firstRow <= matrix.length - 1 && lastRow >= 0 && 
                firstCol <= matrix[0].length - 1 &&  lastCol >= 0 && list.size() < N){

            //firstRow
            for(int index = firstRow;  index <= lastCol &&  list.size() < N ; index++){
                list.add(matrix[firstRow][index]);
            }
            firstRow++;

            //lastCol
            for(int index = firstRow; index <= lastRow && list.size() < N; index++){
                list.add(matrix[index][lastCol]);
            }     
            lastCol--;

            //lastRow
            for(int index = lastCol ; index >= firstCol && list.size() < N; index--){
                list.add(matrix[lastRow][index]);
            }
            lastRow--;

            //firstCol
            for(int index = lastRow; index >= firstRow && list.size() < N ; index--){
                list.add(matrix[index][firstCol]);
            }
            firstCol++;
      }
      return list;
    }
}
