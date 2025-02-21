/*
[    1            ]
 0 1 2 3. --- 25
"leetcode"
char - c -'a'
       99 - 97
*/
class Solution {
    public int firstUniqChar(String s) {
        int[] chars = new int[26];

        for(char ch : s.toCharArray()){
         chars[ch - 'a']++;
        }
        for(int index = 0; index < s.length() ; index++){
            if(chars[s.charAt(index) - 'a'] == 1)
                return index;
        }

       return -1;
    }
}