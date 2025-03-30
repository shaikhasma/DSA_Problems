/*
- A partition is complete when we reach the index end and it is equal to partitionEnd. This means:
- All characters in the current partition appear only within this range.
- Any character appearing later does not belong to this partition.
- We can safely "cut" the string at this point.
Note - At index end, if partitionEnd == end, it means no character from the current partition appears later in the string. So, we finalize the partition.
TC - 0(N)
SC - 0(1)
*/
class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastIndex = new int[26]; // Stores last occurrence of each character
        
        // Fill lastIndex array
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        
        List<Integer> result = new ArrayList<>();
        int start = 0, partitionEnd = 0;
        
        // Iterate through the string to find partitions
        for (int end = 0; end < s.length(); end++) {
            partitionEnd = Math.max(partitionEnd, lastIndex[s.charAt(end) - 'a']);
            if (partitionEnd == end) { // Found a valid partition
                result.add(end - start + 1);
                start = end + 1; // Move start to next partition
            }
        }
        return result;
    }
}
