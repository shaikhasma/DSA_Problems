class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        int leftSum = 0;

        // Step 1: Calculate total sum of the array
        for (int num : nums) {
            totalSum += num;
        }

        // Step 2: Iterate to find the pivot index
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i; // Found pivot index
            }
            leftSum += nums[i]; // Update left sum
        }

        return -1; // No pivot index found
    }
}