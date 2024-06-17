/*
    TC - 0(N*N * I + NlogN) I is length of longest string in the words[]/. nlog n sorting
    SC - 0(N)  dp[]
*/
class Solution {
    static Comparator<String> compareStrLen = (s1, s2) -> s1.length() - s2.length();

    static boolean compare(String s1, String s2){
        if(s1.length() != 1 + s2.length())
            return false;

        int first = 0;
        int second = 0;

        while(first < s1.length()){
            if(second < s2.length() && s1.charAt(first) == s2.charAt(second)){
                first++;
                second++;
            }
            else
                first++;
        }
        
        // if both first & second reaches to end simultaneously it means its valid 
        return first == s1.length() && second == s2.length();
    }

    public int longestStrChain(String[] words) {
        int n = words.length;
        
        //sort String[] based on length
        Arrays.sort(words, compareStrLen);

        int[] dp = new int[n];
        Arrays.fill(dp, 1);


        for(int index = 0; index < n; index++){
            for(int prevIndex = 0; prevIndex <= index - 1; prevIndex++){
                
                if(compare(words[index], words[prevIndex]) && dp[index] < 1 + dp[prevIndex]){
                    dp[index] = 1 + dp[prevIndex];
                }
            }

           
        }

        int maxIndex = 1;
        for(int index = 0; index < n; index++)
             maxIndex = Math.max(maxIndex, dp[index]);

        return maxIndex;
    }
}