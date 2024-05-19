/*. Approach - 4 Space Optmization
TC - 0(N)
SC - 0(1)   
     dp. 
*/
class Solution {
    public int climbStairs(int n) {
        int prev1 = 1;
        int prev2 = 1;

        for(int index = 2; index <= n; index++){
          int current = prev1 + prev2;
          prev2 = prev1;
          prev1 = current;
        }        
     
       return prev1;
    }
}