
/* Approach 2 - Sliding window + hashing

1. start left right both from 0 
2. move right by one step every time check 
 - if righ char present Check 
  --- if prevIndex is not in range dont move left 
      else move  left to prevIndex of character + 1
 - add right character into map with index

 - Calculate length ( right - left + 1)

TC- 0(N)
SC - 0(N) 

*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
      if(s.length() == 0 ){
          return 0;
      }

      int left = 0;
      int len = 0;
      int maxLen = 0;
      HashMap<Character, Integer> map = new HashMap<Character,Integer>();
      for(int right = 0; right < s.length(); right++){
          char ch = s.charAt(right);
          if(map.containsKey(ch)){
              int prevIndex = map.get(ch);
              left = Math.max(prevIndex + 1, left);
          }

          map.put(ch, right);
          len = right - left + 1;
          maxLen = Math.max(maxLen, len);
      }
      return maxLen;
    }
}