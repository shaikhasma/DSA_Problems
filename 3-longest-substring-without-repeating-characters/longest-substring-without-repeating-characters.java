
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
      int ans = 0;
      int len = 0;

      while(right < s.length()){ 
       Character ch = s.charAt(right);

       if(!set.contains(ch)){
        set.add(ch);
        right++;
        len++;
       }
       else{
        left++;
        right = left;
        set = new HashSet<>();
        len = 0;
       }

       ans = Math.max(ans, len);
      }

     return ans;
    }
}