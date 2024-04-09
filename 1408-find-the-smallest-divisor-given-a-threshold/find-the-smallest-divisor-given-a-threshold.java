/* Approach 2  - Binary Search

- Get min and max number 
- apply binary search 1 to max for divisor
  -- traverse array 
  -- divide array[index] by divisor take ceil of division
  -- keep divison 
 Once array traversal completes then check division sum with threshold
  -- if less than or equal threshould. 
       Return divisor which is minimum as we are traversing from min to max

TC - 0(N * log(max (nums[]) ))
SC - 0(1) 
*/
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = getMinMax(nums);
        int minDivisor = -1;
        while(low <= high){
            int mid = (high + low ) / 2;
            int divisionSum = calculateDivisionSum(nums, mid);
        
            if(divisionSum <= threshold){
                minDivisor = mid;
                high = mid - 1;
            }else{
                low = mid +1;
            }
        }

        return minDivisor;
    }

    int calculateDivisionSum(int[] nums, int divisor){
        int divisionSum = 0;
        for(int index = 0; index < nums.length; index++)
            divisionSum += Math.ceil((double) nums[index] / (double) divisor);
        
        return divisionSum;
    }

    int getMinMax(int[] nums){
        int max = Integer.MIN_VALUE;

        for(int index = 0 ; index < nums.length; index++){
            max = Math.max(max, nums[index]);
        }

        return max;
    }
}