/* Approach - Optimized
- Traverse 0 to end
1. increment count when we found 1
2. make count = 0 when we found any number rather than 1
- Every time maintain maxCount

- Return maxOneCount


TC- 0(n)
SC- 0(1)
*/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxOneCount = 0;

        for(int index = 0; index < nums.length; index++){
            if(nums[index] == 1){
                count++;
            }
            else {
                count=0;
            }
            maxOneCount = Math.max(maxOneCount, count);
        }

        return maxOneCount;
    }
}