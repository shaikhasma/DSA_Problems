class Solution {
    public int[] productExceptSelf(int[] nums) {
      int zeroCount = 0;
      int prod = 1;

      for(int index = 0; index < nums.length; index++){
          if(nums[index] != 0 )
             prod = prod * nums[index];
          else
             zeroCount++;
      }

      for(int index = 0; index < nums.length; index++){
          if(zeroCount == 0){
              nums[index] = prod / nums[index];
          }else if ( zeroCount == 1 && nums[index] != 0){
              nums[index] = 0;
          }else if ( zeroCount == 1 && nums[index] == 0){
              nums[index] = prod;
          }else{
              nums[index] = 0;
          }
      }

    return nums;
    }
}