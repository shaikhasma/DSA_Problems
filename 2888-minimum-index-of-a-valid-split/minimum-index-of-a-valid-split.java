import java.util.*;

class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        
        // Step 1: Find the majority element using Moore's Voting Algorithm
        int me = nums.get(0);
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (nums.get(i) == me) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                me = nums.get(i);
                count = 1;
            }
        }

        // Step 2: Validate that 'me' is actually the dominant element
        count = 0;
        for (int num : nums) {
            if (num == me) count++;
        }

        // Step 3: Find the minimum index for a valid split
        int leftCount = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) == me) leftCount++;
            int rightCount = count - leftCount;
            if (leftCount * 2 > (i + 1) && rightCount * 2 > (n - 1 - i)) {
                return i;
            }
        }

        return -1;
    }
}