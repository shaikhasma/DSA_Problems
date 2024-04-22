/*
 Approach - 2 Sliding window + Hashing 128chars

 TC - 0(2N) + 0(M)
    - 0(N+M)
 SC - 0(128)
*/
class Solution {
    public String minWindow(String s, String t) {
        
        int minLength = Integer.MAX_VALUE;
        int startIndex = -1;
        int count = 0;
       
        int left = 0;
        int right = 0;

        int[] hash = fillHashWithT(t);
        while(right < s.length()){
            if(hash[s.charAt(right)] > 0){
                count++;
            }
            
            hash[s.charAt(right)]--;
        
            while(count == t.length()){
                int len = right - left + 1;
                
                if(len <= minLength){
                    minLength = len;
                    startIndex = left;
                }
                
                hash[s.charAt(left)]++;
                
                if(hash[s.charAt(left)] > 0 ){
                    count--;
                }
                    
                left++;
                
            }  
            right++;

        }
        
        if(startIndex == -1)
           return "";
          return s.substring(startIndex ,startIndex + minLength);
    }


   //TC - 0(M)
    int[] fillHashWithT(String t){
        int[] hash = new int[128];
        for(int index = 0; index < t.length(); index++){
            hash[t.charAt(index)]++;
        }
        return hash;
    }
}