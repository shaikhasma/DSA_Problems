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
        int[] charsCount = new int[26];
        int n = s.length();

        for(int index = 0; index < n; index++){
            char c = s.charAt(index);
            charsCount[c - 'a'] = charsCount[c - 'a'] + 1;
        }

        for(int index = 0; index < n; index++){
            char c = s.charAt(index);
            if(charsCount[c - 'a'] == 1)
                return index;
        }

        return -1;
    }
}