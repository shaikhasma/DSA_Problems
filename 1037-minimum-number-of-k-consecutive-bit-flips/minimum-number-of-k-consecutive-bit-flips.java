class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int flip = 0;
        int[] diff = new int[n]; 
        for (int i = 0; i < n; i++) {
            flip ^= diff[i];
            if ((nums[i] ^ flip) == 0) { 
                if (i + k > n) return -1;
                ans++;
                flip ^= 1; 
                if (i + k < n) {
                    diff[i + k] ^= 1;
                }
            }
        }
        return ans;
    }
}