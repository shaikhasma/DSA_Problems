/*

Approach - 1 Traverse a to z chars 

TC : O(26) * N
indexOf and lastIndexOf: 0(N) worst Case
Extract substring and calculate distinct characters → O(n) per letter in the worst case.
   0(N)
    public int countPalindromicSubsequence(String s) {
      
        int res = 0;
        
        // Iterate over all possible characters ('a' to 'z')
        for (char c = 'a'; c <= 'z'; c++) {
            // Find the first and last occurrence of the current character
            int start = s.indexOf(c);
            int end = s.lastIndexOf(c);
            
            // If there is a valid range between first and last occurrence
            if (start != -1 && end != -1 && start < end) {
                // Use a set to track unique characters between start and end
                res += s.substring(start + 1, end)
                        .chars()
                        .distinct()
                        .count();
            }
        }
    
        return res;
    }

SC - 0(N) unique chars beween 1st and last chars
------------------------------------------------------------------------------------------------------
 Appraoch - 2  find all unique chars + traverse unique chars get each unique char first and last index 
 1. Find all unique char of string and store into set
 2. traverse all unique chars 
   - get first index of char
   - get last index of char
3. Traverse between firstIndex and lastIndex check 
   - how many unique chars are there so we can find 3 size palindrome string
   - count unique chars size and add into main ans

TC - unqiue chars 0(26) , traverse 0(26) , traverse between 1st and last index 0(N)
SC - count unique 0(26)

TC - 0(N)
SC - 0(1)

   public int countPalindromicSubsequence(String s) {
        int ans = 0;
        Set<Character> uniqueChars = new HashSet<>();

        for(char ch : s.toCharArray()){
            uniqueChars.add(ch);
        }

        for(char ch : uniqueChars){
            int firstIndex = s.indexOf(ch);
            int lastIndex = s.lastIndexOf(ch);

            if(firstIndex < lastIndex){
                Set<Character> countUniqueChars = new HashSet<>();
                for(int index = firstIndex + 1; index < lastIndex; index++){
                    countUniqueChars.add(s.charAt(index));
                }

                ans+= countUniqueChars.size();
            }
        }

        return ans;
    }

*/
class Solution {
    public int countPalindromicSubsequence(String s) {
        int ans = 0;
        Set<Character> uniqueChars = new HashSet<>();

        for(char ch : s.toCharArray()){
            uniqueChars.add(ch);
        }

        for(char ch : uniqueChars){
            int firstIndex = s.indexOf(ch);
            int lastIndex = s.lastIndexOf(ch);

            if(firstIndex < lastIndex){
                Set<Character> countUniqueChars = new HashSet<>();
                for(int index = firstIndex + 1; index < lastIndex; index++){
                    countUniqueChars.add(s.charAt(index));
                }

                ans+= countUniqueChars.size();
            }
        }

        return ans;
    }

}