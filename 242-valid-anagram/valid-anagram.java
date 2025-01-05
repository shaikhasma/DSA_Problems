class Solution {
    public boolean isAnagram(String str1, String str2) {
        if(str1.length() != str2.length())
            return false;
        
        for(int index = 0; index < str1.length(); index++){
            char ch = str1.charAt(index);
            int indexOfChar = str2.indexOf(ch);

            if(indexOfChar != -1 ){
               str2 = str2.substring(0, indexOfChar) +
                str2.substring( indexOfChar + 1, str2.length());
            }
            else{
                return false;
            }
        }

        return true;
    }
}