/*
1,2,1,3,5,6,4 ===> 5 index
        m
6 5 3 2 1
    m
5 4 3 1   ==> 0

1 2 3 4 5 ===> 4
*/

class Solution {
    public int findPeakElement(int[] nums) {
       if(nums.length == 1|| nums[0] > nums[1]) return 0;
       if( nums[nums.length - 1] > nums[nums.length - 2]) return nums.length - 1;

       int low = 1;
       int high = nums.length - 1;

       while(low <= high){
        int mid = (high + low ) / 2;

        if(nums[mid] > nums[mid - 1] && nums[mid ] > nums[mid + 1] )
           return mid;
        
        if(nums[mid] < nums [mid - 1])
           high = mid - 1;
        else if (nums[mid] > nums[mid - 1])
           low = mid + 1;
       }
     return - 1;

    }
}