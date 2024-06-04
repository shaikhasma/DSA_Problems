/** Asma shaikh
Approach - 1 Recursion
 TC : 0(N) + 0(2^n)
 SC : 0(N)  

Program - 
    public boolean canPartition(int[] nums) {
     int totSum = 0;
     for(int index = 0; index < nums.length; index++)
        totSum += nums[index];

     if( totSum % 2 == 1)
        return false;
        
     return solv(nums, totSum / 2, nums.length - 1);
    }

    boolean solv(int[] A, int target, int index){
        if(target == 0)
            return true;
    
        if(index == 0)
            return A[index] == target;
                
        boolean pick = false;
        if(A[index] <= target)
            pick = solv(A, target - A[index], index - 1);

        boolean notPick = solv(A, target, index - 1);

        return pick || notPick;
    }

 */
class Solution {
    public boolean canPartition(int[] nums) {
     int totSum = 0;
     for(int index = 0; index < nums.length; index++)
        totSum += nums[index];

     if( totSum % 2 == 1)
        return false;

     int[][] dp = new int[nums.length][totSum / 2 + 1];
     for(int[] row : dp)
        Arrays.fill(row, -1);

     return solv(nums, totSum / 2, nums.length - 1, dp);
    }

    boolean solv(int[] A, int target, int index,int[][] dp){
        if(target == 0)
            return true;
    
        if(index == 0)
            return A[index] == target;
                
        if(dp[index][target] != -1)
            return dp[index][target] == 1 ? true : false;

        boolean pick = false;
        if(A[index] <= target)
            pick = solv(A, target - A[index], index - 1, dp);

        boolean notPick = solv(A, target, index - 1, dp);

        dp[index][target] = (pick || notPick) ? 1 : 0;
        
        return pick || notPick;
    }
}