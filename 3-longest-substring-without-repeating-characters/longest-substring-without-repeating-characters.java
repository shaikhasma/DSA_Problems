
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
      if(s.length() == 0 || s.length() == 0){
          return s.length();
      }

     
      int maxLen = 0;
      for(int left = 0; left < s.length(); left++){
          HashSet<Character> set = new HashSet<>();
          int len = 0;
          for(int right = left ; right< s.length(); right++){
              
                 if(set.contains(s.charAt(right))){
                     break;
                 }
    
          set.add(s.charAt(right));
          len++;
          maxLen = Math.max(maxLen,len);
          }
      }
      return maxLen;
    }
}