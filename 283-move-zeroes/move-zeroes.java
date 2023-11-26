/* Approach - maintain left zero position + swap with non -zero
TC - 0(n)
SC- 0(1)
*/
class Solution {
    public void moveZeroes(int[] nums) {
        int leftZero = 0;
        int current = 0;
        while(current < nums.length ){
            if(nums[current] != 0){
                if(leftZero != current){
                   nums[leftZero] = nums[current];
                   nums[current] = 0;   
                }
              leftZero++;
            }
            current++;
        }
    }
       
}


