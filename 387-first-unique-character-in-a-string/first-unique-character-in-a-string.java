/*
[    1            ]
 0 1 2 3. --- 25
"leetcode"
char - c -'a'
       99 - 97
*/
class Solution {
    public int firstUniqChar(String s) {

        for(int index = 0; index < s.length() ; index++){
            char ch = s.charAt(index);
            if(s.indexOf(ch) == s.lastIndexOf(ch))
                return index;
        }

       return -1;
    }
}