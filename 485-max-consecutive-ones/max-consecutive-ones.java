class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxLen = 0;
        int count = 0;
        for(int index = 0; index < nums.length ; index++){
            if(nums[index] == 1)
                count ++;
            else
                count = 0;
            
            maxLen = Math.max (count, maxLen);
            
        }
        return maxLen;
    }

}