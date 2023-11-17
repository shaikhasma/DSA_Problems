/*
 Approach 3 - Kadane's Algorithm 
 TC- 0(n)
 SC - 0(1)
*/
class Solution {
    public int maxSubArray(int[] nums) {
     if(nums.length == 1)
       return nums[0];
     int sum = 0;
     int maxSum = Integer.MIN_VALUE;
     for(int index = 0; index < nums.length ; index++){
         sum = sum + nums[index];
         maxSum = Math.max(maxSum, sum);   
         
         if(sum < 0)
            sum = 0;
     }
    return maxSum;
    }
}

