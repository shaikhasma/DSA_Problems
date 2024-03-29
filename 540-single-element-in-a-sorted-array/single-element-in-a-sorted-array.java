/*  
Approach 1 - Binary Search
 1,1,2,3,3,4,4,8,8
 0 1 2 3 4 5 6 7 8
 l       M       h  
 8/2 = 4

 3,3,7,7,10,11,11
 0 1 2 3  4  5   6 
 6/2 = 3
 10/ 2 = 5

 8/2 

 TC - o(logn)
 SC - 0(1)



 */
class Solution {
    public int singleNonDuplicate(int[] nums) {
      //Corner case

      if(nums.length == 1) return nums[0];
      if(nums[0] != nums[1]) return nums[0];
      if(nums[nums.length - 2] != nums[nums.length - 1]) return nums[nums.length - 1 ];

      int low = 1;
      int high = nums.length - 2;
      while(low <= high){
        int mid = high - (high - low) / 2;

        if(nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1])
            return nums[mid];
        
        if((mid % 2 == 0 && nums[mid] == nums[mid + 1]) ||
                    (mid % 2 == 1 && nums[mid]== nums[mid - 1]))
            low = mid + 1;
        else 
            high = mid - 1;
      }

      return -1;
    }
}