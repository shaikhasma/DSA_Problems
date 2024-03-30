/* Approach - 2 Binary Search
TC = 0(logN)
SC = 0(1)



0 1 2 3 4 5 6
2,5,6,0,0,1,2
      m

*/
class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = (high + low ) / 2;
            
            if(nums[mid] == target){
                return true;
            }

            if(nums[mid] == nums[low] && nums[mid] == nums[high]){
                low = low + 1;
                high = high - 1;
                continue;
            }

            if(nums[low] <= nums[mid]){
                if(nums[low] <= target && target <= nums[mid] )
                {
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
            else{
                if(nums[mid] <= target && target <= nums[high] ){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }

        }
        return false;
    }
}