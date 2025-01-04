/*
 Appraoch - find all unique chars + traverse unique chars get each unique char first and last index 
 1. Find all unique char of string and store into set
 2. traverse all unique chars 
   - get first index of char
   - get last index of char
3. Traverse between firstIndex and lastIndex check 
   - how many unique chars are there so we can find 3 size palindrome string
   - count unique chars size and add into main ans

TC - 0(N)
SC - 0(N)

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