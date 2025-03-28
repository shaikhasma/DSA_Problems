/* 
Approach - 1 Explore all paths using DFS
1. Each query call DFS to explore all paths
 TC - 0(k * NM) k queries nm grid elements
 SC - 0(NM) + 0(NM) visited array stack space else constants

 Appraoch - 2.  Sort + Min Heap + BFS
1. Sort the queries → This ensures that we process them efficiently.
2. Use BFS with Min-Heap (PriorityQueue) → Process grid cells in increasing order.
3. Expand only valid cells (i.e., grid values less than query value).
4. Store results in original query order → Using sorted indices. 

TC - 0(k log k) + 0(NM log(NM))
     sorting         processing
    - 0((nm + k ) log(NM))

SC - 0(NM) visited , heap
public int[] maxPoints(int[][] grid, int[] queries) {
        int n = grid.length, m = grid[0].length;
        int k = queries.length;
        int[] result = new int[k];

        // Sort queries with their original indices
        int[][] queryPairs = new int[k][2];
        for (int i = 0; i < k; i++) {
            queryPairs[i] = new int[]{queries[i], i};
        }
        Arrays.sort(queryPairs, Comparator.comparingInt(a -> a[0]));

        // Min-Heap (stores: [grid value, row, col])
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        boolean[][] visited = new boolean[n][m];
        
        // BFS directions
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        // Start BFS from (0,0)
        minHeap.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;
        
        int points = 0; // Number of cells collected
        int lastValue = 0; // Last processed grid value
        
        for (int i = 0; i < k; i++) {
            int qVal = queryPairs[i][0], index = queryPairs[i][1];

            // Expand BFS while grid values are smaller than the current query
            while (!minHeap.isEmpty() && minHeap.peek()[0] < qVal) {
                int[] cell = minHeap.poll();
                int r = cell[1], c = cell[2];
                
                // Count unique reachable cells
                if (cell[0] != lastValue) {
                    lastValue = cell[0];
                }
                points++;

                // Explore neighbors
                for (int[] dir : directions) {
                    int nr = r + dir[0], nc = c + dir[1];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        minHeap.offer(new int[]{grid[nr][nc], nr, nc});
                    }
                }
            }

            result[index] = points;
        } 
        return result;
    }

 */

class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int n = grid.length, m = grid[0].length;
        int k = queries.length;
        int[] result = new int[k];

        // Sort queries with their original indices
        int[][] queryPairs = new int[k][2];
        for (int i = 0; i < k; i++) {
            queryPairs[i] = new int[]{queries[i], i};
        }
        Arrays.sort(queryPairs, Comparator.comparingInt(a -> a[0]));

        // Min-Heap (stores: [grid value, row, col])
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        boolean[][] visited = new boolean[n][m];
        
        // BFS directions
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        // Start BFS from (0,0)
        minHeap.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;
        
        int points = 0; // Number of cells collected
        int lastValue = 0; // Last processed grid value
        
        for (int i = 0; i < k; i++) {
            int qVal = queryPairs[i][0], index = queryPairs[i][1];

            // Expand BFS while grid values are smaller than the current query
            while (!minHeap.isEmpty() && minHeap.peek()[0] < qVal) {
                int[] cell = minHeap.poll();
                int r = cell[1], c = cell[2];
                
                // Count unique reachable cells
                if (cell[0] != lastValue) {
                    lastValue = cell[0];
                }
                points++;

                // Explore neighbors
                for (int[] dir : directions) {
                    int nr = r + dir[0], nc = c + dir[1];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        minHeap.offer(new int[]{grid[nr][nc], nr, nc});
                    }
                }
            }

            result[index] = points;
        }
        
        return result;
    }
}
