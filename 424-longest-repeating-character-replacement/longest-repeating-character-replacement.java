/*
  Approach - 1 Sliding Window

  1. start left & right from 0
  2. make freqCount in hashTable[s.charAt(index) - 'A'] as we know all are Capital letters
  3. maintain max frequency
  4  calculate required Flips
      length - max frequency
  5. if required flips are more than given K then no need to go ahead
      here shrink window size from left 
       --- reduce freq count in hashTable[s.charAt(left)--] by one
       --  update maxFreq to 0
       -- left++
       



   6. if required flip cout M= k
         calculate length
         maintain / carry max length

    Return maxLength

    TC - 0(N) + 0(N) 
       - 0(N) 
    Sc - 0(1) or 0(26)

*/


class Solution {
    public int characterReplacement(String s, int k) {
        int count = 0;
        int[] hashTable = new int[26];
        int maxFreq = 0;
        int maxLen = 0;

        int left = 0;
        int right = 0;
        Arrays.fill(hashTable, 0);
        while(right < s.length()){
            
            hashTable[s.charAt(right) - 'A']++;

            maxFreq = Math.max(maxFreq, hashTable[s.charAt(right) - 'A']);
            int requiredFlipCount = (right - left + 1) - maxFreq;
            
            if(requiredFlipCount > k){
                hashTable[s.charAt(left) - 'A']--;
                
                // update maxFreq
                  maxFreq = 0;
                  
                //shrnik window from left
                left++;
            }
            
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }
}