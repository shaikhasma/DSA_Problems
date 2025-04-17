class Solution {
    public boolean isAnagram(String str1, String str2) {
        if(str1.length() != str2.length())
            return false;
        
        int[] freq = new int[26];
        for(int index = 0; index < str1.length(); index++){
            char ch1 = str1.charAt(index);
            char ch2 = str2.charAt(index);
            freq[ch1 - 'a'] ++;
            freq[ch2 - 'a'] --;
        }

        for(int index = 0; index < freq.length; index++)
        {
            if(freq[index] != 0)
                return false;
        }

        return true;
    }
}