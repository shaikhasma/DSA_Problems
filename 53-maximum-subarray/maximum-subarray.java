/*
 Approach 4 - Kadane's Algorithm'  
 TC- 0(n)
 SC - 0(1)
*/
class Solution {
    public int maxSubArray(int[] nums) {
    if(nums.length == 1)
        return nums[0];
    //Step 1 : Take two sum and max sum
    //         sum = 0 & maxSum = -INFINITY

    int sum = 0;
    int maxSum = Integer.MIN_VALUE;
    //Step 2 : traverse 0 to n-1 make  add every element into sum 
    for(int index = 0 ; index < nums.length; index++){
        sum = sum + nums[index];
        
        //Step 3 : if sum became < 0 it wont give max sum so make it zero for next calculation
        maxSum = Math.max(maxSum, sum);

        if(sum < 0)
          sum = 0;
    }

    return maxSum;
    }
}

