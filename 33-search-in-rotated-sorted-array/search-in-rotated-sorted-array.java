class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = (high + low) / 2;

            if( nums[mid] == target )
                return mid;
            
            //left is sorted or not
            if(nums[low] <= nums[mid]){
                //taret lie between low & mid or not

                if( target >= nums[low] && target <= nums[mid]){
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }//else righ is sorted
            else{
                if(target >= nums[mid] && target <= nums[high]){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}