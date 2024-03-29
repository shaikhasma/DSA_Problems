/* Approach - using Lower Bound & Upper Bound
TC - 0(log N) + 0(log N) = 0(log N)
SC - 0(1)
*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{ -1, -1};
        if(nums.length == 1 && nums[0] == target) return new int[]{0 , 0};
        int firstPosition = getLowerBound(nums,target);

       if( firstPosition == nums.length || nums[firstPosition] != target ) 
               return new int[]{ -1, -1};   
       int lastPosition = getUpperBound(nums,target);

        return new int[]{firstPosition, lastPosition - 1};
    }

    int getLowerBound(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        int lowerBound = nums.length;
        while(low <= high){
            int mid = high - ( high - low) / 2;
            if(nums[mid] == target)
                lowerBound = mid;
            
            if(nums[mid] >= target)
                high = mid - 1;
            else
                low = mid + 1;

        }

        return lowerBound;
    }

    int getUpperBound(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        int upperBound = nums.length;

        while(low <= high){
            int mid = high - (high - low) /2;

            if(nums[mid] > target){
              high = mid - 1;
              upperBound = mid;
            }
            else 
              low = mid + 1;
        }

        return upperBound;
    }
}