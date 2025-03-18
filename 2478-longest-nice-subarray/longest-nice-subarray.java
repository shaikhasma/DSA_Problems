class Solution {
   public int longestNiceSubarray(int[] nums) {
       int bitMask = 0;
       int left = 0;
       int maxLength = 0;
       int right = 0;

       while (right < nums.length) {
           while ((bitMask & nums[right]) != 0)
               bitMask ^= nums[left++];

           bitMask |= nums[right];
           maxLength = Math.max(maxLength, right - left + 1);
           right++;
       }
       
       return maxLength;    
    }
}