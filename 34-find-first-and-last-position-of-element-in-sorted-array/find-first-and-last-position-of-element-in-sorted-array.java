/* Approach - Brute Force
TC - 0(N)
SC - 0(1)
*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstIndex = -1;
        int lastIndex = -1;

        for(int index = 0; index < nums.length ; index ++){
            if(target == nums[index]){
                if(firstIndex == - 1){
                    firstIndex = index;
                    lastIndex = index;
                }
                else{
                    lastIndex = index;
                }
            }
        }
        return new int[] {firstIndex , lastIndex};
    }
}