class Solution {
    public int maximumCount(int[] nums) {
        int posCount = 0;
        int negCount = 0;
        for( int index = 0; index < nums.length; index++){
            if(nums[index] < 0)
                negCount++;
            else if(nums[index] > 0)
                posCount++;
        }
        return Math.max(posCount, negCount);
    }
}