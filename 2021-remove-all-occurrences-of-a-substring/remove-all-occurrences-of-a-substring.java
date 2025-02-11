/*
  Approach 1.  - using contains() , indexOf, substring predefined functions
  contains(part): O(N)
  indexOf(part): O(N)
  substring() operations: O(N)

In the worst case, the loop runs O(N/M) times, where M is the length of part.
Overall O(N² / M) worst-case complexity.

  TC - O(N² / M) worst-case complexity.
  SC - 0(N) due to immutable string operations creating new strings.

   public String removeOccurrences(String s, String part) {
        while(s.contains(part)){
            int index = s.indexOf(part);
            s = s.substring(0,index)+s.substring(index+part.length());
        }

        return s;
    }
-----------------------------------------------------------------------
Approach - 2 Using string builder like stack
1. attach each character one by one to stringbuilder
2. check last characters which are equals length like part length
   if both are equal then remove
   To Remove,

   delete(total string length - part length,  total length)
           starting                            end

* indexOf(String str)
    Finds the index of the first occurrence of str inside StringBuilder.
    Returns -1 if str is not found.

* delete(int start, int end)
    Removes characters from start (inclusive) to end (exclusive).
    This is faster than using immutable substring() operations.
T.C - 
    Each character is processed once → O(N)
    substring() check at most O(M) → O(N * M) in the worst case
    0(N) approximatly

SC - O(N) StringBuilder 

 public String removeOccurrences(String s, String part) {
     StringBuilder sb = new StringBuilder();
        int partLength = part.length();

        for (char c : s.toCharArray()) {
            sb.append(c);
            if (sb.length() >= partLength && sb.substring(sb.length() - partLength).equals(part)) {
                sb.delete(sb.length() - partLength, sb.length());
            }
        }
        return sb.toString();
    }
*/
class Solution {
    public String removeOccurrences(String s, String part) {
     StringBuilder sb = new StringBuilder();
        int partLength = part.length();

        for (char c : s.toCharArray()) {
            sb.append(c);
            if (sb.length() >= partLength && sb.substring(sb.length() - partLength).equals(part)) {
                sb.delete(sb.length() - partLength, sb.length());
            }
        }
        return sb.toString();
    }
}