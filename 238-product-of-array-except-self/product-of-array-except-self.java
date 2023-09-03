class Solution {
    public int[] productExceptSelf(int[] nums) {
     int[] left = new int[nums.length];
     int[] right = new int[nums.length];
     int[] res = new int[nums.length];

     left[0] = nums[0];
     right[nums.length - 1] = nums[nums.length - 1];
     for(int index = 1; index < nums.length; index++){
      left [index] = left [index - 1] * nums[index];
     }

     for(int index = nums.length - 2; index >= 0 ; index--){
         right[index] = right[index + 1] * nums[index];
     }
    res[0] = right[1];
    res[nums.length - 1] = left[nums.length - 2];
     for(int index = 1; index <= nums.length - 2; index++){
         res[index] = left[index - 1] * right[index + 1];
     }
    return res;
    }
}