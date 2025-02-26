/*
 Approach - Kadane's also and minPrefix & maxSum 
 if max sum is +ve then fine i.e answer
 if maxSum is -ve  then means in short minsum would be answer
 TC - 0(N + N)
 SC - 0(1)
*/
class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int minSum = minPrefixSum(nums);
        int maxSum = maxPrefixSum(nums);

        return  Math.max(
            Math.abs(minSum) , Math.abs(maxSum)
        );
    }

    int maxPrefixSum(int[] nums){
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for( int index = 0; index < nums.length; index++){
            sum += nums[index];
            maxSum = Math.max(sum, maxSum);

            if(sum < 0)
                sum = 0;
        }

        return maxSum;
    }

    int minPrefixSum(int[] nums){
        int minSum = Integer.MAX_VALUE;
        int sum = 0;
        for( int index = 0; index < nums.length; index++){
            sum += nums[index];
            minSum = Math.min(sum, minSum);
           
            if(sum > 0)
                sum = 0;
        }

        return minSum;
    }
    
}