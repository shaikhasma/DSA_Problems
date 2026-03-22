
/* Approach 1 - Check all substring + hashing + two pointer

1. Traverse all substring 
2. once we find duplicate  calculate leng from start to end and stop 
  and break that substring there it self
3. Maintain max len
4. Add character ( if character is already added it wont add again so add directly)
TC- 0(N^2)
SC - 0(N)

"abcabcbb"

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

    TC - 0(n^2) Note - Restart right from evey index
    SC - 0(N)

Approach - 2 Using HashMap store char + index & avoid restarting window for each time
 - If char present in map compare prevIndex + 1 and current left
      this is to check duplicate character is current window of left -> right 
       if yes then move left to maxIndex
       update index(right) to map for that character 

       Note this is just to avoid moving left to backwoard

-- if not present put new char + index

*/

class Solution {  
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = 0;

        for(int right = 0; right < s.length(); right++){
            Character ch = s.charAt(right);

            if(map.containsKey(ch)){
                Integer preIndex = map.get(ch);
                left = Math.max(left, preIndex + 1) ;
            }
            
            map.put(ch, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
}