class Solution {
    public int[] productExceptSelf(int[] nums) {
     int[] left = new int[nums.length];

    left[0] = nums[0];
     
     for(int index = 1; index < nums.length ; index++){
         left[index] = left[index - 1] * nums[index];
     }
     
     left [nums.length - 1] = left[nums.length - 2]; 
     int prod = 1;
     for(int index = nums.length - 1 ; index > 0; index--){
         left [index] = left[index - 1] * prod;
         prod = prod * nums[index];
     }
     left[0] = prod;
     return left;
    }
}

