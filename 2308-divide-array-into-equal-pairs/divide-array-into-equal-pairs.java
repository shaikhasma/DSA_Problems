class Solution {
    public boolean divideArray(int[] nums) {
        int[] freq = new int[501]; 
        for (int e : nums) {
            freq[e]++;
        }
        for (int count : freq) {
            if (count % 2 != 0) return false;
        }
        return true;
        
    }
}