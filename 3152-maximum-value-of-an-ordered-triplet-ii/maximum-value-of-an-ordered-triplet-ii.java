class Solution {
     public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] lmax = new int[n]; // Stores max value from left up to index i
        int[] rmax = new int[n]; // Stores max value from right up to index i
        
        // Initialize left and right max arrays
        lmax[0] = nums[0];
        rmax[n - 1] = nums[n - 1];
        
        // Fill lmax array: lmax[i] holds the maximum value in nums[0...i]
        for(int i = 1; i <= n - 3; i++) {
            lmax[i] = Math.max(lmax[i - 1], nums[i]);
        }
        
        // Fill rmax array: rmax[i] holds the maximum value in nums[i...n-1]
        for(int i = n - 2; i >= 2; i--) {
            rmax[i] = Math.max(rmax[i + 1], nums[i]);
        }
        
        long res = 0L;
        // Iterate over middle element (nums[i])
        for(int i = 1; i < n - 1; i++) {
            // Compute triplet value using lmax[i-1], nums[i], and rmax[i+1]
            res = Math.max(res, (lmax[i - 1] - nums[i]) * (long) rmax[i + 1]);
        }
        
        return res;
     }
}