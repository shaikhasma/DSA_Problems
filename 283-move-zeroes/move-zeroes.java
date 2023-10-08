/* Approach - maintain left zero position + swap with non -zero
TC - 0(n)
SC- 0(1)
*/
class Solution {
    public void moveZeroes(int[] nums) {
       int leftMostZero = 0;
       int i = 0;

        while(i < nums.length){
            if( nums[i] != 0){
               if(leftMostZero != i){
                 nums[leftMostZero] = nums[i];
                 nums[i] = 0;
               }
               leftMostZero++;
            }
            i++;
        }
      
    }
}

