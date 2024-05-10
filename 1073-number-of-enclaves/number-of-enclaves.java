class Node{
    int row;
    int col;
    public Node(int row, int col){
      this.row = row;
      this.col = col;
    }
}

class Solution {
    public int numEnclaves(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<Node> q = new LinkedList<>();
        // first row & last row
        for(int index = 0; index < grid[0].length; index++){
            if(grid[0][index] == 1 && !visited[0][index]){
                q.add(new Node(0, index));
                 visited[0][index] = true;
            }
            
            if(grid[grid.length - 1][index] == 1 && !visited[grid.length - 1][index]){
                q.add(new Node(grid.length - 1, index));
                visited[grid.length - 1][index] = true;
            }
            
        }

        // first col & last Col
        for(int index = 0; index < grid.length; index++){
            if(grid[index][0] == 1 && !visited[index][0]){
                q.add(new Node(index, 0));
                 visited[index][0] = true;
            }

            if(grid[index][grid[0].length - 1] == 1 && !visited[index][grid[0].length - 1]){
                q.add(new Node(index, grid[0].length - 1));
                 visited[index][grid[0].length - 1] = true;
            }
        }

        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1}; //{0, +1, +0, -1}; 

        while(!q.isEmpty()){
            Node node = q.poll();
         
            for(int index = 0; index < 4; index++){
                   //System.out.println(node.col + "---"+ index);
                int nRow = node.row + dRow[index];
                int nCol = node.col + dCol[index];

                if(nRow >= 0 && nRow < grid.length && nCol >= 0 && nCol <  grid[0].length &&
                    grid[nRow][nCol] == 1 && !visited[nRow][nCol]){
                    q.add(new Node(nRow,nCol));
                     visited[nRow][nCol] = true;
                }
              
            }
        }

        // Traverse Grid
        int landCells = 0;
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == 1 && !visited[row][col])
                     landCells++;
            }
        }

        return landCells;
    }
}