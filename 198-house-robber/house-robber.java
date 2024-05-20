/*.    Approach 2 - Recursion + Memoization
 TC - 0(N)
 SC - 0(N) + 0(N) 
      dp[].  auxillary stack
*/
class Solution {
    public int rob(int[] nums) {
      int[] dp = new int[nums.length];
      Arrays.fill(dp, -1);
      return maxMoney(nums, nums.length - 1, dp);
    }

    int maxMoney(int[] house, int houseIndex, int[] dp){
        if(houseIndex == 0) 
            return house[houseIndex];

        if(houseIndex < 0)
           return 0;

        if(dp[houseIndex] != -1)
            return dp[houseIndex];

        int pick = house[houseIndex] + maxMoney(house, houseIndex - 2, dp);
        int notPick = maxMoney(house, houseIndex - 1, dp);

        dp[houseIndex] = Math.max(pick, notPick);
        return dp[houseIndex];
    }
}