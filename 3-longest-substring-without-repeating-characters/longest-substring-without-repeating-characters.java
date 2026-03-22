
/* Approach 1 - Check all substring + hashing + two pointer

1. Traverse all substring 
2. once we find duplicate  calculate leng from start to end and stop 
  and break that substring there it self
3. Maintain max len
4. Add character ( if character is already added it wont add again so add directly)
TC- 0(N^2)
SC - 0(N)

"abcabcbb"


*/

class Solution {  
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int max = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);

            if (!set.contains(ch)) {
                set.add(ch);
                max = Math.max(max, right - left + 1);
                right++;
            } else {
                // reset window
                left++;
                right = left;
                set.clear();
            }
        }

        return max;
    }
}