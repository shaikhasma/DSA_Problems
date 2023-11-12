class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
       ArrayList<Integer> list = new ArrayList<>();
       int totalRow = matrix.length;
       int totalCol = matrix[0].length;
       int firstCol = 0;
       int firstRow = 0;
       int lastRow = totalRow - 1;
       int lastCol = totalCol - 1;
       int size = totalRow * totalCol;


       while(list.size() < size){
            //Traverse FirstRow
            for(int col = firstCol ; col <= lastCol && list.size() < size; col++ ){
                list.add(matrix[firstRow][col]);
            }
            firstRow++;
            
            //Traverse Last column
            for(int row = firstRow; row <= lastRow && list.size() < size; row++){
                list.add(matrix[row][lastCol]);
            }
            lastCol--;

            //Traverse Last Row
            for(int col = lastCol; col >= firstCol && list.size() < size; col--){
                list.add(matrix[lastRow][col]);
            }
            lastRow--;

            //Traverse First Col
            for(int row = lastRow; row >= firstRow && list.size() < size; row--){
                list.add(matrix[row][firstCol]);
            }
            firstCol++;
       }
      return list;
    }
}


