/*.    Approach 3 - Tabulation / Bottom up Approach 
 TC - 0(N)
 SC - 0(N) 
      dp[]
*/
class Solution {
    public int rob(int[] nums) {
     int[] dp = new int[nums.length];
     Arrays.fill(dp, -1);

     dp[0] = nums[0];
     for(int index = 1; index < nums.length; index++){
        int pick = nums[ index ]; 
        
        if(index > 1)
           pick +=  dp[index - 2];

        int notPick = dp[index - 1 ];
    
        dp[index] = Math.max(pick, notPick);
     }

     return dp[nums.length - 1];
    }
}