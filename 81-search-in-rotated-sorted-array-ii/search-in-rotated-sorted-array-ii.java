/* Approach - 2 Binary Search
TC = 0(logN)
SC = 0(1)


0 1 2 3 4 5 6
3 3 4 3 3 3 3
    l m h


*/
class Solution {
    public boolean search(int[] nums, int target) {
       int low = 0;
       int high = nums.length - 1;

       while(low <= high){
        int mid = (high + low ) /2;
        
        if( nums[mid] == target) 
            return true;

        if( nums[low] == nums[mid] && nums[mid] == nums[high]){
            low++;
            high--;
            continue;
        }
         // left sorted
        if(nums[low] <= nums[mid]){
            if(nums[low]<= target && nums[mid] >= target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }else{
            if(nums[mid]<= target && nums[high] >= target){
                low = low + 1;
            }
            else{
                high = high - 1;
            }
        }

       }

       return false;
    }
}