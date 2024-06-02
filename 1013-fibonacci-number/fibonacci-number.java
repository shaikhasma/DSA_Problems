/*
  Approach - Recursion  
*/
class Solution {
    public int fib(int n) {
       if( n == 0 || n == 1)
        return n;
        
       int prev = fib(n - 1);
       int pPrev = fib(n - 2);

       return prev + pPrev;
    }
}