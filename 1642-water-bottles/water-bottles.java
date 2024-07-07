class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
      int ans = numBottles;

      while(numBottles >= numExchange){
        int newBottles = numBottles / numExchange;
        ans += newBottles;
        numBottles = newBottles + (numBottles - numExchange * newBottles);
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