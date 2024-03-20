/* Approach - 1 Binary Search
1. find lower bound logn
    - find mid 
    - mid >= target shift to left part of mid to find the lowest index
    - if we found exact match of target then pick that it as lower index
    Repeate above steps till low <= high

2. find upper bound logn
    - find mid 
    - mid <= target shift to right part mid to find the upper index
    - if we found exact match of target then pick that it as upper index
    Repeate above steps till low <= high
TC = 2long n 
   = 0(logN)
SC = 0(1)

*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
       
        int[] ans = new int[2];

        ans[0] = findFirstIndex(nums, target);
        ans[1] = findLastIndex(nums, target);

        return ans;

    }

    int findFirstIndex ( int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        int firstIndex = -1;
      
        while(low <= high){
            int mid = (high + low)/2;

            if(nums[mid] >= target)
                high = mid - 1;
            else
               low = mid + 1;
            

            if(nums[mid] == target)
                firstIndex = mid;
        }

        return firstIndex;
    }

    int findLastIndex ( int[] nums, int target){
            int low = 0;
            int high = nums.length - 1;
            int lastIndex = -1;
        
            while(low <= high){
                int mid = (high + low)/2;

                if(nums[mid] <= target)
                    low = mid + 1;
                else
                   high = mid - 1;
                

                if(nums[mid] == target)
                    lastIndex = mid;
            }

            return lastIndex;
        }

    
}