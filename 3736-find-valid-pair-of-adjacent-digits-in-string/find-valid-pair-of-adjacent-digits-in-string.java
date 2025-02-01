/*
    Approach - Using HashMap
    TC - 0(N)
    SC - 0(1) only 10 size always
*/
class Solution {
    public String findValidPair(String s) {
        String ans = "";
        if(s == null || s.length() == 0) return ans;
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(int index = 0; index < s.length(); index++){
            char digit = s.charAt(index);
            
            if(map.containsKey(digit)){
                int freq = map.get(digit);
                map.put(digit, freq + 1);
            }
            else{
                map.put(digit, 1);
            }
        }

        for(int index = 1; index < s.length(); index++){
            char prev = s.charAt(index - 1);
            char current = s.charAt(index);
            
            if(prev != current && prev - '0' == map.get(prev)  && current - '0'== map.get(current))
                return (ans + prev) + current ;
        }

        return ans;
    }
}