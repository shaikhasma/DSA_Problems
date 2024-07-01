/*
Example : ball1 = 9
          ball2 = 6

triangle with max rows: 
            b1            1 b1 used
          b2  b2          2 b2 used
        b1  b1  b1        3 b1 used
       b2 b2  b2 b2       4 b2 used
     b1 b1 b1  b1  b1     5 b1 used

 b1 occupies 3 rows, and b2 occupies 2 row

 ans = 5
 AP Sum , sn = n/2 (2*a + (n-1)d)

Applying it in eqn-i and eqn-ii,

    b1 = n1/2 (2+(n1-1)*2)
       = n1^2
 => n1 = sqrt(b1)

and 
    b2 = n2/2(2*2+(n2-1)*2)
        = n2*(n2+1)
 => n2^2 + n2 - b2 = 0

Using quadratic formula , n2 = (-b (+-) sqrt(b^2-4ac))/2a
                             = (-1 + sqrt(1+4b2))/2
Hence,
Possible no. of rows occupied by b1  =  sqrt(b1) 
Possible no. of rows occupied by b2  =  (-1+sqrt(1+4b2))/2 

b1 =200
b2 = 1
Case 1 : if n2 >=n1 , ans = 2*n1
Case 2 : if(n1> n2) , ans = 2*n2 + 1
*/
class Solution {
   public int helper(int ball1,int ball2){

        int rowsCount1 = (int)Math.sqrt(ball1);
        int rowsCount2=0;

        if(ball2<=1){
            rowsCount2 = 0;
        }else{
            rowsCount2 =  (-1 + (int)Math.sqrt(1+4*ball2))/2;
        }
        if(rowsCount2 >=rowsCount1){
            return 2*rowsCount1;
        }
        return 2*rowsCount2 +1;
    }

    public int maxHeightOfTriangle(int red, int blue) {
        return Math.max(helper(red,blue),helper(blue,red));
    }
}