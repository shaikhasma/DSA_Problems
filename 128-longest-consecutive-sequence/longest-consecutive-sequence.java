/* Approach - 3 using HashSet
 1. put all elements into hasSet
 2. if the previous of curent element is not present in set 
    means,
         that can be starting point of increasing subsequence
         mark current = nums[index]
         len = 1
    
    From that current starting point check all consective seq 
         current + 1 is present then len++

 4. Every time maintain max len.

 TC - 0(N) + 0(2N) = 0(3N) 
    - 0(N)
 SC - 0(N) 
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> st = new HashSet<>();
        for (int num : nums)
            st.add(num);
        int maxStreak = 0;
        for (int num : st) {
            if (!st.contains(num - 1)) {
                int currNum = num;
                int currStreak = 1;
                while (st.contains(currNum + 1)) {
                    currStreak++;
                    currNum++;
                }
                maxStreak = Math.max(maxStreak, currStreak);
            }
        }
        return maxStreak;
    }
}