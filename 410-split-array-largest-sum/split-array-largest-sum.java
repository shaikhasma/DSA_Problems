/* Approach 2 Binary Search
  - find max of array i.e low
  - find sum o array.  i.e high

1. Every thing will be same just apply binary search from 
          max to sum of array for maxSum
     --- split arrays  with maxSum and count splited array
         return spliated count
     --- if splited array is equal to given k 
          return maxSum

Note- as we are going from min to max ( max sum array to sum of array ) 
     so the first we found k splited array with max sum that max sum is min from maximum so return directly
 
 2. if we dont split k splicate  then return first elemetn of array
      
  TC - 0(N * log(sum(nums) - max ( nums ) -1 ))
  SC - 0(1)
*/
class Solution {
    public int splitArray(int[] nums, int k) {
        int[] maxAndSum = maxAndSumOfArray(nums);
        int low = maxAndSum[0];
        int high = maxAndSum[1];

        while(low <= high ) {
            int mid = high - (high - low) / 2;
            int splitedArrayCount = countSplitArrays(nums, mid);
            
            if(splitedArrayCount > k)
               low = mid + 1;
            else
               high = mid - 1;

        }
        
        // we dont find min of largest sum of k splited array then in this case nums[0] of array will be the minimum of larest array
        return low;
    }

    int[] maxAndSumOfArray(int[] nums){
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for(int index = 0 ; index < nums.length ; index++){
            sum += nums[index];
            max = Math.max(max, nums[index]);
        }

        return new int[]{max, sum};
    }

    int countSplitArrays(int[] nums, int maxSum){
        int splitedArrayCount = 1;
        int splitedArraySum = 0;

        for(int index = 0; index < nums.length; index++){
            if(splitedArraySum + nums[index] <= maxSum){
                // add current to same splitedArray
                splitedArraySum += nums[index];
            }else{
               // add current to next spliatedArray
                splitedArrayCount++;
                splitedArraySum = nums[index];
            }
        }

        return splitedArrayCount;
    }
}