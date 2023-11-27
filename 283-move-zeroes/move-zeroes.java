/* Approach - maintain left zero position + swap with non -zero
TC - 0(n)
SC- 0(1)
*/
class Solution {
    public void moveZeroes(int[] nums) {
        int leftZero = 0;
        int current = 0;
        if(nums.length == 1)
        return;
        while(current < nums.length ){
            if(nums[current] != 0){
                   int temp = nums[leftZero];
                   nums[leftZero] = nums[current];
                   nums[current] = temp;   
              leftZero++;
            }
            current++;
        }
    }
       
}


