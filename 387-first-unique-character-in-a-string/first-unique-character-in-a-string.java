/*
 l - 1
 e - 3
 t - 1
 c - 1
 0 - 1
 d - 2
 TC - 0(N) + 0(N)
 SC - 0(N)

*/
class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        int n = s.length();

        for(int index = 0; index < n; index++){
            char c = s.charAt(index);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(int index = 0; index < n; index++){
            if(map.get(s.charAt(index)) == 1)
                return index;
        }

        return -1;
    }
}