/* Approach
1. Drink numBottles make it empty & count completed water
   ans = numBottles;
2. Exchange empty Bottles with new filled water
3. prev emptyBottles + newEmpty Bottles ( can make is empty after drunk)

always count new filled bottles

Once Empty Bottle < exchange bottle we have to stop
*/
class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
      int ans = numBottles;
      int remaningEmptyBottles = numBottles;

      while(remaningEmptyBottles >= numExchange){
        int newBottles = remaningEmptyBottles / numExchange;
        ans += newBottles;

        remaningEmptyBottles = (remaningEmptyBottles % numExchange) + newBottles;
      }
      
      return ans;
    }
}

  /* 9 / 3. 3/3 
9.  3.      1
   15/4  3/4
15. 3    1
7. 2. 3 1 0
7 3 
*/