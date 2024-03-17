class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
     List<Integer> spiralList = new ArrayList<>();
     int totalElement = matrix.length * matrix[0].length;
     int firstRow = 0;
     int lastCol = matrix[0].length - 1;
     int lastRow = matrix.length - 1;
     int firstCol = 0;

     while(spiralList.size() < totalElement){
        // 1stRow traversal
        for(int col = firstCol; col <= lastCol && spiralList.size() < totalElement;  col++){
            spiralList.add(matrix[firstRow][col]);
        }
        firstRow++;

        // lastCol traversal
            for(int row = firstRow; row <= lastRow && spiralList.size() < totalElement;  row++){
            spiralList.add(matrix[row][lastCol]);
        }
        lastCol--;


        //lastRow traversal
        for(int col = lastCol; col >= firstCol && spiralList.size() < totalElement;  col--){
            spiralList.add(matrix[lastRow][col]);
        }
        lastRow--;

        
        //firstCol Traverse
        for(int row = lastRow; row >= firstRow && spiralList.size() < totalElement;  row--){
            spiralList.add(matrix[row][firstCol]);
        }
        firstCol++;

        }
        return spiralList;
    }
}




