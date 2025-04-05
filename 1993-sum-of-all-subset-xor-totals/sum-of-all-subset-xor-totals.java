class Solution {
    int sum = 0;
    public int subsetXORSum(int[] nums) {
        solv(nums, 0, 0);
        return sum;
    }

    void solv(int[] nums, int index, int xor){
        if( index >= nums.length){
            sum += xor;
            return;
        }

        //pick
        solv(nums, index + 1, xor ^ nums[index]);
        
        //not pick
        solv(nums, index + 1, xor);
    }
}