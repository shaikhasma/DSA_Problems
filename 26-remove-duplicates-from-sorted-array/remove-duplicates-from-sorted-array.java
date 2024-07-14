/*
     l
 0,1,1,1,1,2,2,3,3,4
           r
*/
class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 0;
        int right= 1;
        while(right < nums.length){
            if(nums[left] != nums[right]){
                left++;
                nums[left] = nums[right];
            }
            right++;
        }

        return left + 1;
    }
}