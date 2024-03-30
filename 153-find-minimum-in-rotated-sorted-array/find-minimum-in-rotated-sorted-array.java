/*
Appraoch = Binary Search
 0 1 2 3 4 
[3,4,5,1,2]

TC- 0(lonN)
SC - 0(1)


take min = +Infinity

compare min with mid if less keep min value in min

if left / righ high is sorted or not
take min value compare with min variable and keep min in min variable from sorted half and go ahead....



*/
class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int min = Integer.MAX_VALUE;


        while(low <= high){

            int mid = (high + low) / 2;
            
            min = Math.min(min, nums[mid]);

            if(nums[low] <= nums[mid]){
                min = Math.min(min, nums[low]);
                low = mid + 1;
            }
            else{
                min = Math.min(min, nums[mid]);
                high = mid - 1;
            }

        }

        return min;
    }
}