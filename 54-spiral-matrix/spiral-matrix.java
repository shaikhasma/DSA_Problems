class Solution {
    public List<Integer> spiralOrder(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        int size = row * col;
        
        List<Integer> list = new ArrayList<>();
        int firstRow = 0;
        int lastCol = col - 1;
        int lastRow = row - 1;
        int firstCol = 0;

        while(list.size() < size){
             // first Row traverse ( change col)
             for(int index = firstCol ; index <= lastCol && list.size() < size ; index++){
               list.add(arr[firstRow][index]);
             }
             firstRow++;

             // last col traverse (change row)
             for(int index = firstRow; index <= lastRow && list.size() < size; index++){
                list.add(arr[index][lastCol]);
             }
             lastCol--;
             
             // last row in reverse order
                for(int index = lastCol; index >= firstCol && list.size() < size; index--){
                    list.add(arr[lastRow][index]);
                }
            lastRow--;

             // 1st colum in reverse order
             for(int index = lastRow ; index >= firstRow && list.size() < size; index--){
                list.add(arr[index][firstCol]);
             }
             firstCol++;
        }

        return list;
    }
}