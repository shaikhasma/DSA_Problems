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

Approach - 2 Recursion + Memoiation 
TC - 0(NT) - 0(N) sum 
SC - 0(NK) + 0(N) dp[][] & stack

Program -   
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

Approach - 3 Tabulation / Bottom up
TC - 0(NM)
SC - 0(N) + 0(N)

Program - 
    public boolean canPartition(int[] nums) {
     int totSum = 0;
     for(int index = 0; index < nums.length; index++)
        totSum += nums[index];

     if( totSum % 2 == 1)
        return false;

     int T = totSum / 2;
     boolean[][] dp = new boolean[nums.length][T + 1];

     //Base Case initialize 1
     for(int index = 0; index < nums.length; index++)
        dp[index][0] = true;

    //Base Case initialize 2
     if(nums[0] <= T)
        dp[0][nums[0]] = true;
     
     for( int index = 1; index < nums.length ; index++){
        for(int target = 0; target <= T; target++){
         
         boolean pick = false ;
         if(nums[index] <= target )
            pick = dp[index - 1][target - nums[index]];

         boolean notPick = dp[index - 1][target];

         dp[index][target] = pick || notPick;
        }
     }
     return dp[nums.length - 1][T];
    }
 */
class Solution {
    public boolean canPartition(int[] nums) {
     int totSum = 0;
     for(int index = 0; index < nums.length; index++)
        totSum += nums[index];

     if( totSum % 2 == 1)
        return false;

     int T = totSum / 2;
     boolean[][] dp = new boolean[nums.length][T + 1];

     //Base Case initialize 1
     for(int index = 0; index < nums.length; index++)
        dp[index][0] = true;

    //Base Case initialize 2
     if(nums[0] <= T)
        dp[0][nums[0]] = true;
     
     for( int index = 1; index < nums.length ; index++){
        for(int target = 0; target <= T; target++){
         
         boolean pick = false ;
         if(nums[index] <= target )
            pick = dp[index - 1][target - nums[index]];

         boolean notPick = dp[index - 1][target];

         dp[index][target] = pick || notPick;
        }
     }
     return dp[nums.length - 1][T];
    }
}