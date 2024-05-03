/*
   Approach - Two pointer Approach
   1. traverse left and right 
   left = 0 for version 1
   right = 0 for version 2

   2. compare all digits into number except point

   3. compare both number if 
       nums < return -1 
       else nums > reurn 1
        
        else go ahead 
            left ++
            right++

         check digits after point and do the came thing

    TC - 0(N + M)
    SC = 0(1)
             
   */
class Solution {
    public int compareVersion(String version1, String version2) {
        int left = 0, right = 0;
        while (left < version1.length() || right < version2.length()) {
            int num1 = 0, num2 = 0;

            while (left < version1.length() && version1.charAt(left) != '.') {
                num1 = num1 * 10 + (version1.charAt(left++) - '0');
            }

            while (right < version2.length() && version2.charAt(right) != '.') {
                num2 = num2 * 10 + (version2.charAt(right++) - '0');
            }
            if (num1 < num2) {
                return -1;
            }

            if (num1 > num2) {
                return 1;
            }

            left++;
            right++;
        }
        return 0;
    }
}
