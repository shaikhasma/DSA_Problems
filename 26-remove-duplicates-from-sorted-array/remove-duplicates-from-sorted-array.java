class Solution {
    public int removeDuplicates(int[] nums) {
     int first = 0;
     int second = 1;
     while(second <= nums.length - 1 ){
         if(nums[first] != nums[second]){
             first++;
             nums[first] = nums[second];
         }

         second++;
     }
    return first + 1;
    }
}

/*
1   2   3   5     5
   .        i         j      
*/