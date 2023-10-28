class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int len = 0;
        int maxLen = 0;
        int left = 0;
        for(int index = 0; index < s.length(); index++){
           char ch= s.charAt(index);
           
           if(map.containsKey(ch)){
              left = Math.max(map.get(s.charAt(index)) + 1, left);
           }
          
            map.put(ch,index);
            len = index - left + 1;
            maxLen = Math.max(len, maxLen);   
        }

        return maxLen;

    }
}