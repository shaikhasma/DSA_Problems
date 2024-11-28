/* Asma shaikh
Approach - Hashing
TC- 0(2n) = > 0(n)
SC - 0(n)
*/
class Solution {
    public int majorityElement(int[] nums) {
        int element = 0;
        int count = 0;
        for(int index = 0; index < nums.length; index++){
            if(count == 0){
                element = nums[index];
                count++;
            }else if(nums[index] != element){
                count--;
            }else{
                count++;
            }
        }

        int freqCount = 0;
        for(int index = 0; index < nums.length; index++){
            if(nums[index] == element){
                freqCount++;
            }
        }
        
        if(freqCount > nums.length / 2){
            return element;
        }
    
    return -1;
    }
}