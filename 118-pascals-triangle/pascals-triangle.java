class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        for(int row = 0; row < numRows ; row++){
            ArrayList<Integer> rowList = new ArrayList<>();
            
            for(int col = 0; col <= row; col++){
                 if(col == 0 || col == row){
                   rowList.add(1);

                 }else{
                   int prevCol = list.get(row - 1).get(col - 1);
                   int currCol = list.get(row - 1).get( col );
                     rowList.add(prevCol + currCol);
                 }
            }
            list.add(rowList);
        }

        return list;
    }
}
