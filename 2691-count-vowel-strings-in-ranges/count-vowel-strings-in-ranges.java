class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] vowelStrings = prefixVowelString(words);
        
        int[] ans = new int[queries.length];
        int index = 0;
        for(int[] query : queries){
            int start = query[0];
            int end = query[1];

            if(start == 0)
                ans[index++] = vowelStrings[end];
            else
                ans[index++] = vowelStrings[end] - vowelStrings[start - 1];
        }

        return ans; 
    }

    int[] prefixVowelString(String[] words){
        int[] prefixStrings = new int[words.length];
        String firstWord = words[0];
        if(isVowel(firstWord.charAt(0)) && 
                isVowel(firstWord.charAt(firstWord.length() - 1)))
           prefixStrings[0] = 1 ;

        for(int index = 1; index < words.length; index++){
            String str = words[index];
            prefixStrings[index] = isVowel(str.charAt(0)) && isVowel(str.charAt(str.length() - 1)) ?
                                      prefixStrings[index - 1] + 1:
                                      prefixStrings[index - 1];
        }
        
        return prefixStrings;
    }

    boolean isVowel(char ch){
         ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' ||ch == 'i' ||ch == 'o' ||ch == 'u' ;
    }
}