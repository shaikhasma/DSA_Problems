/*
When a number can be represented as a sum of distinct powers of 3, it means that each digit in its base-3 representation must be either 0 or 1.
If any digit in base-3 form is 2, then that means it's requiring 2 * (some power of 3), which is not allowed in our rule.

TC - O(log₃(n))
SC - O(1)  

*/
class Solution {
    public boolean checkPowersOfThree(int n) {
      while (n > 0) {
        // If any digit in base-3 representation is 2, return false
            if (n % 3 == 2)     
                return false;

            n /= 3;
        }
        return true;

    }
}