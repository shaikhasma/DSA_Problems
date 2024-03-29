/* Approach - 1 Brute Force

- traverse 0 to N - 1
- if current equals to target return current index
- compare taret lie between current and next element or not
TC - 0(N)
SC - 0(N)
*/
class Solution {
    public int searchInsert(int[] nums, int target) {
       
        if(target <= nums[0] ) return 0;
        if(target > nums[nums.length - 1]) return nums.length;

        for(int  index = 0; index < nums.length - 1 ; index++){
            if(nums[index] == target) return index;

            if(target > nums[index]  && target < nums[index + 1])
              return index + 1;

        } 
        return nums.length - 1;
    }
}