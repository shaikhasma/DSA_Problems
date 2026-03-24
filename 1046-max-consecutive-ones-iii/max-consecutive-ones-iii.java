/*
Note - Take this problem as find longest subarray with at most k zeros

 Approach - 1 all subarray with max k zeros and find longest subarray
 TC - 0(N^2)
 SC - 0(1)

 public int longestOnes(int[] nums, int k) {
      int maxLen = 0;
      for( int left = 0; left < nums.length; left++){
        int zeroCount = 0;
        for( int right = left ; right < nums.length; right++){
            if(nums[right] == 0)
               zeroCount++;
            
            if(zeroCount <= k){
                maxLen = Math.max(maxLen, right - left + 1);
            }else{
                break;
            }
        }
      }
      return maxLen;
    }

Appraoch - 2 Sliding Window

TC - 0(N)
SC - 0(1)
*/

class Solution {
    public int longestOnes(int[] nums, int k) {
      int left = 0;
      int right = 0;
      int zeroCount = 0;
      int maxLen = 0;

      while(right < nums.length){
        if(nums[right] == 0)
            zeroCount++;
        
            while(zeroCount > k){
                if(nums[left] == 0)
                    zeroCount--;

                left++;
            }

        maxLen = Math.max(maxLen, right - left + 1);
        right++; 
      }
      return maxLen;
    }
}