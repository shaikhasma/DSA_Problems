/* Approach - 3 Binary Exponational + binary operator
TC - 0(log2(N))
SC - 0(1)
*/

class Solution {
    public double myPow(double x, int n) {
        //if n is -ve
        if(n < 0) {
            n = -n;
            x = 1 / x;
        }
        
        double ans = 1;
        while(n != 0){
            //multiple only when number is oddodd number
            if((n & 1) != 0){
                ans = ans * x;
            } 
                
            x *= x;
            n >>>= 1; // n /= 2 or n = n >> 2
        }

   

    return ans;
    }
    
}