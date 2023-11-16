/* Approach 3 Three Pointer Approach
TC - 0(n)
SC- 0(1)
1. start left & mid from 0
2. start right from n-1
3. move mid 
-- if we found 0 swap with left  move left , mid
-- if we found 2 swap with right move right -- 
-- if we found 1 dont do any thing move mid
*/
class Solution {
    public void sortColors(int[] nums) {
      int left = 0;
      int mid = 0;
      int right = nums.length - 1;
      while(mid <= right){
          if(nums[mid] == 0){
              swap(nums, mid, left);
              mid++;
              left++;
          }else if(nums[mid] == 2){
              swap(nums,mid, right);
              right--;
          }else{
              mid++;
          }
      }
    }
    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}