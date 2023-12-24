class Solution {
    final static char ONE = '1';
    final static char ZERO = '0';
    public static int minOperations(String s) {
        char firstChar = s.charAt(0);
        

        int countWithoutFlipStart = countFlip(s, firstChar);
        int countWithFlipStart = countFlip(s, firstChar == ZERO ? ONE : ZERO) + 1;

        return Math.min(countWithoutFlipStart, countWithFlipStart);
    }

   static int countFlip(String s, char prevChar){
        int totalFlip = 0;

        for(int index = 1; index < s.length(); index++){
            char current = s.charAt(index);
            if(current == prevChar){
                totalFlip++;
                prevChar = (current == ZERO ? ONE: ZERO ); 
            }else{
                prevChar = current;
            }
        }
        return totalFlip;
    }

}