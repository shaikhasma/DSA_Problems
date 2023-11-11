/* Approach - 2 NCR formula 
TC- O(n-1) or  O(m-1) depending on formula which we are using
SC- 0(1)
*/
class Solution {
    public int uniquePaths(int m, int n) {
       int N = n + m - 2;
       int r = m - 1; 
       double res = 1;
            
        for (int i = 1; i <= r; i++)
            res = res * (N - r + i) / i;
        return (int)res;
    }
}