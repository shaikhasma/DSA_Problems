class Solution {
    public int waysToSplitArray(int[] nums) {
        long[] rightPrefix = rightPrefixSum(nums);
        long leftSum = nums[0];
        int validWays = 0;

        for(int index = 1; index < nums.length; index++){
            if(leftSum >= rightPrefix[index])
                validWays++;

            leftSum += nums[index];
        }

        return validWays;

    }
    
    long[] rightPrefixSum(int[] nums){
        int n = nums.length;
        long[] rightPrefix = new long[n];

        rightPrefix[n - 1] = nums[n - 1];
        for(int index  = n - 2; index >= 0; index--){
            rightPrefix[index] = rightPrefix[index + 1] + nums[index];
        }

        return rightPrefix;
    }

}