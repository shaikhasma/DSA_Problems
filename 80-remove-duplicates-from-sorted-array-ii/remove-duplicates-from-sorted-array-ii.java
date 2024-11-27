/*
1,1,2,2,2,3
    l 
  r

*/
class Solution {
    public int removeDuplicates(int[] nums) {
        int prevIndex = 1;
        for(int currentIndex = 1; currentIndex < nums.length; currentIndex++){
            if(prevIndex == 1 || nums[currentIndex] != nums[prevIndex - 2]){
                nums[prevIndex] = nums[currentIndex];
                prevIndex++;
            }
        }

        return prevIndex;

        
    }
}