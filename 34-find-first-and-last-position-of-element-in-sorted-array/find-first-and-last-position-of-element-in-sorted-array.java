/* Approach - Brute Force
TC - 0(N)
SC - 0(1)
*/
/* Approach - 2 Using binary search

1. find firstIndex using binary search
-- if we find exact target update index 
-- if we find >= target move left to get first index 
do this till low <= high

2. find lastIndex using binary search

-- if we find exact target update index 
-- if we find <= target move right to get last index 
do this till low <= high
TC - 0(logN) + 0(logN)
SC - 0(1)

*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
      int firstIndex = findFirstIndex(nums, target);
      int lastIndex = findLastIndex (nums, target);

      return new int[] {firstIndex, lastIndex};
    }

    int findFirstIndex(int[] nums, int target){
        int low = 0 ;
        int high = nums.length - 1;
        int firstIndex = -1;
        while(low <= high){
            int mid = (high + low) / 2;
            //updating firstIndex  every time my moving left 
            if(nums[mid] == target){
                firstIndex = mid;
            }

            if(nums[mid] >= target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return firstIndex;
    }

    int findLastIndex (int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        int lastIndex = -1;

        while(low <= high){
          int mid = (high + low ) / 2;
          
          //updating last index everytime by moving right side
          if(nums[mid] == target){
            lastIndex = mid;
          }
          
          if(nums[mid] <= target){
            low = mid + 1;
          }
          else{
            high = mid - 1;
          }
        }

        return lastIndex;

    }
}