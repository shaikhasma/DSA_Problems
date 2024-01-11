class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
     int countZero = 0;
     int maxCount = 0;
     
     for(int index = 0; index < nums.length ; index++){
         countZero = nums[index] == 1 ? countZero + 1 : 0;
         maxCount = Math.max(maxCount, countZero);
     }
     
     return maxCount;
    }

}