class Solution {
    int[][] dp ;
    public boolean canPartition(int[] nums) {
        int sum = 0;
       
        for(int index = 0; index < nums.length; index++)
            sum+= nums[index];

        if(sum % 2 == 1)
            return false;

        dp = new int[sum/2 + 1][nums.length];
        for(int[] arr : dp)
            Arrays.fill(arr, -1);

        return solve(nums, 0, sum/2);
    }

    boolean solve(int[] nums, int index, int target){
        if(target == 0)
            return true;
        
        if(index == nums.length - 1) 
            return nums[index] == target;
        
        if(dp[target][index] != -1)
            return dp[target][index] == 1 ? true : false;

        //1. take 
        boolean take = false;
        if(nums[index] <= target)
            take = solve( nums, index + 1, target - nums[index]);
        
        // 2. not take
        boolean notTake = solve(nums, index + 1, target);

        dp[target][index] = (take || notTake) ? 1 : 0;
        return dp[target][index] == 1 ? true: false;
    }
}