class Solution {
    public int maximumDifference(int[] nums) {
        int minn = Integer.MAX_VALUE;
        int diff = -1;
        for (int i : nums) {
            if (i <= minn) {
                minn = i;
            } else {
                diff = Math.max(diff, i - minn);
            }
        }
        return diff;
    }
}