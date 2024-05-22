/* Approach - 1 Dijkstra Algorithm
TC - O( 4 * N * M *             log( N*M) )
     N*M are the total cells,  insertion-deletion operations in a priority queue 
     
    = O( 4*N*M * log( N*M) ) 

TC - 0(N * M) + 0(N * M)
       dist         pq
    = 0(N * M) 
*/
class Node{
    int dist ;
    int row ;
    int col;
    public Node(int dist, int row, int col){
        this.dist = dist;
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>((x, y) ->
                                    x.dist - y.dist);
        
        int totRow = heights.length;
        int totCol = heights[0].length;
        int[][] dist = new int[totRow][totCol];
        
        // Mark dist for all with +infinity
        for(int row = 0; row < totRow; row++){
            for(int col = 0; col < totCol; col++){
                dist[row][col] = (int)1e9;
            }
        }  
        
        dist[0][0] = 0;
        pq.add(new Node(0,0,0));
        int[] dirRow = {-1, 0, 1, 0};
        int[] dirCol = {0, 1, 0, -1};

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int row = node.row;
            int col = node.col;
            int diff = node.dist;

            //reached the destination cell,
            //current value of difference (which will be min).
            if(row == totRow - 1 && col == totCol - 1)
                return diff;

            for( int index = 0; index < 4; index++){
                int nRow = row + dirRow[index];
                int nCol = col + dirCol[index];

                // boundary check + validity check
                if(nRow >= 0 && nRow < totRow && nCol >= 0 &&  nCol < totCol ){
                    int newEffort = Math.max(
                                        Math.abs(heights[row][col] - heights[nRow][nCol]),
                                        diff
                                    );

                    if(newEffort < dist[nRow][nCol]){
                        dist[nRow][nCol] = newEffort;
                        pq.add(new Node(newEffort, nRow , nCol));
                    }
                }

            }
        }

        return 0;
    }
}