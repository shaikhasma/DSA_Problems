class Solution {
    public double myPow(double x, int n) {
        if(n == 0 || x == 1.0)
            return 1;

        long tempN = n; 
        //if N negative make it +ve
        if(n < 0){
            x = 1/x;
            tempN = -1L * n;
        }

        double ans = 1.0;
        // N times multiplication
        while( tempN > 0){
            if(tempN % 2 == 1){
               ans = ans * x;
               tempN--;
            }
            
            x = x * x;
            tempN >>= 1;
        }

        return ans;
    }
}