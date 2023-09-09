class Solution {
    public int[] rearrangeArray(int[] nums) {
       int[] arr = new int[nums.length];
        int positive = 0;
        int negative = 1;
        for(int index = 0; index < nums.length; index++) {
            if(nums[index] > 0) {
                arr[positive] = nums[index];
                positive += 2;
            }
            else {
                arr[negative] = nums[index];
                negative += 2;
            }
        }
        return arr;
    }
}