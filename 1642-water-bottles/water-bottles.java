/*
At each step, empties shrinks roughly by a factor proportional to numExchange.

The number of iterations is bounded by O(numBottles / numExchange).
TC - O(N/M)
SC - 0(1)
*/
class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
      
      if(numBottles < numExchange)  
        return numBottles;
      
     int totalDrinks = numBottles;
     int remainingBottle = numBottles;
     int newBottle = 0;

     while(remainingBottle >= numExchange){
       
        newBottle = remainingBottle / numExchange; //15 / 4
        remainingBottle = (remainingBottle % numExchange ) + newBottle;
        totalDrinks += newBottle;  
     }
     return totalDrinks;
    }
}