/*
[-2,1,-3,4,-1,2,1,-5,4]
                     i  

maxSum = 6
sum =  0 

*/

class Solution {
    public int maxSubArray(int[] nums) {
      
    
     int maxSum = Integer.MIN_VALUE;
     int sum = 0;

     for(int index = 0; index < nums.length; index++){
        
        sum += nums[index];
        maxSum = Math.max(maxSum, sum);

        if(sum < 0){
            sum = 0;
        }

     }

     return maxSum;
    }
}


