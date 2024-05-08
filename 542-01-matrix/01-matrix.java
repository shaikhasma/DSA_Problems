/*
  Approach - BFS + visited + dis[]

  TC - 0(N * M * 4)
     - 0(NM)
  SC - 0(N * M) + 0(N * M )
     - 0(NM)
*/
class Node{
    int row ;
    int col ;
    int step;
    public Node(int row, int col, int step){
        this.row = row;
        this.col = col;
        this.step = step;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        int[][] dist = new int[mat.length][mat[0].length];
        
        Queue<Node> q = new LinkedList<>();
        for(int row = 0; row < mat.length; row++){
            for(int col = 0; col < mat[0].length; col++){
                if(mat[row][col] == 0){
                    q.add(new Node(row, col, 0));
                    visited[row][col] = true;
                }
            }
        }

       while(!q.isEmpty()){
        
            Node node = q.poll();
            dist[node.row][node.col] = node.step;

            int[] dRow = {0, 1, 0, -1};
            int[] dCol = {-1, 0, 1 , 0};
        
                for(int index = 0 ; index < 4 ; index++){
                int row = node.row + dRow[index];
                int col = node.col + dCol[index];
                
                    if(row >= 0 && row < mat.length && col >= 0 && col < mat[0].length 
                        && !visited[row][col]){
                    
                            q.add(new Node(row, col , node.step + 1));
                            visited[row][col] = true;
                }
                }

       }
       return dist;
    }
}