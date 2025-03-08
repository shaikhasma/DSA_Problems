class Solution {
    public int minimumRecolors(String blocks, int k) {
        int minRecolors = Integer.MAX_VALUE;
        int whiteCount = 0;
        
        // Count W's in the first k-length window
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                whiteCount++;
            }
        }
        
        minRecolors = whiteCount;

        // Sliding window: shift right and update whiteCount
        for (int i = k; i < blocks.length(); i++) {
            // Remove leftmost character from the previous window
            if (blocks.charAt(i - k) == 'W') {
                whiteCount--;
            }
            // Add the new rightmost character
            if (blocks.charAt(i) == 'W') {
                whiteCount++;
            }

            minRecolors = Math.min(minRecolors, whiteCount);
        }

        return minRecolors;
    }
}