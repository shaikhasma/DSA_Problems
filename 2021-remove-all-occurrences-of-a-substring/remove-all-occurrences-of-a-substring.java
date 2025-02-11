/*
  approach - using contains() , indexOf, substring predefined functions
  contains(part): O(N)
  indexOf(part): O(N)
  substring() operations: O(N)

In the worst case, the loop runs O(N/M) times, where M is the length of part.
Overall O(N² / M) worst-case complexity.

  TC - O(N² / M) worst-case complexity.
  SC - 0(N) due to immutable string operations creating new strings.
*/
class Solution {
    public String removeOccurrences(String s, String part) {
        while(s.contains(part)){
            int index = s.indexOf(part);
            s = s.substring(0,index)+s.substring(index+part.length());
        }

        return s;
    }
}