/*
  Approach - 1 Brute force + hashTable[26]

  1. Generate all substring
  2. make freqCount in hashTable[s.charAt(index) - 'A'] as we know all are Capital letters
  3. maintain max frequency
  4  calculate required Flips
      length - max frequency
  5. if required flips are more than given K then no need to go ahead
     else 
         calculate length
         maintain / carry max length

    Return maxLength

    TC - 0(N^2)
    Sc - 0(1) or 0(26)

*/


class Solution {
    public int characterReplacement(String s, int k) {
        int count = 0;
        int[] hashTable = new int[26];
        int maxFreq = 0;
        int maxLen = 0;

       
        
        for(int start = 0 ; start < s.length(); start++){
            Arrays.fill(hashTable, 0);

            for(int end = start; end < s.length(); end++){
                hashTable[s.charAt(end) - 'A']++;

                maxFreq = Math.max(maxFreq, hashTable[s.charAt(end) - 'A']);
                int requiredFlipCount = (end - start + 1) - maxFreq;
                if(requiredFlipCount > k)
                   break;
                else
                    maxLen = Math.max(maxLen, end - start + 1);
            }
        }

        return maxLen;
    }
}