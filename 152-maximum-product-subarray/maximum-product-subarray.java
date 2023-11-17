/* Appraoch 1 Carry Forward
TC - 0(n^2)
SC - 0(1)
*/

class Solution {
    public int maxProduct(int[] nums) {
      if(nums.length == 1)
       return nums[0];

      int max = Integer.MIN_VALUE;
       for(int start = 0 ; start < nums.length; start++){
           int product = 1;
           for(int end = start; end < nums.length; end++){ 
                 product = product * nums[end];
                 max = Math.max(max, product);
           }
       }
       return max;
    }
    
}