/* 
Approach - Recursion 
TC - 0(2^NM)
SC - 0(N) + 0(M)

Program - 
        public int minimumTotal(List<List<Integer>> triangle) {
            return solv(triangle, 0 , 0);
        }
        int solv(List<List<Integer>> triangle, int row, int col){

            if(row == triangle.size() - 1)
                return triangle.get(row).get(col);

            int left = triangle.get(row).get(col) + solv(triangle, row + 1, col);
            int right = triangle.get(row).get(col) + solv(triangle, row + 1, col + 1);

            return Math.min(left, right);
        }
  
Approach - 2 Recursion + Memoiation 
TC - 0(NM)
SC - 0(NM) + 0(NM) recursion & dp[]
   - 0(NM)

Program - 
        public int minimumTotal(List<List<Integer>> triangle) {
            int row = triangle.size();
            int col = triangle.get(row - 1).size();

            int[][] dp = new int[row][col];

            return solv(triangle, 0 , 0, dp);
        }
        int solv(List<List<Integer>> triangle, int row, int col, int[][] dp){

            if(row == triangle.size() - 1)
                return triangle.get(row).get(col);

            if(dp[row][col] != 0)
                return dp[row][col];

            int left = triangle.get(row).get(col) + solv(triangle, row + 1, col, dp);
            int right = triangle.get(row).get(col) + solv(triangle, row + 1, col + 1, dp);

            return dp[row][col] = Math.min(left, right);
    }
*/
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int col = triangle.get(row - 1).size();
   
        int[][] dp = new int[row][col];
        for(int[] dpRow : dp)
            Arrays.fill(dpRow, -1);

        return solv(triangle, 0 , 0, dp);
    }
    int solv(List<List<Integer>> triangle, int row, int col, int[][] dp){

        if(row == triangle.size() - 1)
            return triangle.get(row).get(col);

        if(dp[row][col] != -1)
            return dp[row][col];

        int left = triangle.get(row).get(col) + solv(triangle, row + 1, col, dp);
        int right = triangle.get(row).get(col) + solv(triangle, row + 1, col + 1, dp);

        return dp[row][col] = Math.min(left, right);
    }
}