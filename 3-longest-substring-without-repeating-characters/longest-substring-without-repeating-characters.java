
/* Approach 1 - Check all substring + hashing

1. Traverse all substring 
2. once we find duplicate  calculate leng from start to end and stop 
  and break that substring there it self
3. Maintain max len
4. Add character ( if character is already added it wont add again so add directly)
TC- 0(N^2)
SC - 0(N)
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
       if(s.length() == 0|| s.length() == 1)
          return s.length();


       int len = 0;
       int maxLen = 0;
       for(int left = 0; left < s.length(); left++){
          HashSet<Character> set = new HashSet<Character>();
          len = 0; 
          for(int right = left; right < s.length(); right++){
            char ch = s.charAt(right);
         
              if(set.contains(ch)){
                  // we are at duplicate character that why not right - left + 1
                  break;
              }

              //if will never add repeat char
              set.add(ch);
              len++; 
              maxLen = Math.max(len, maxLen);
          }
       }
       return maxLen;
    }
}