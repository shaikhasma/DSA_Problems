/* Approach - 2 Binary Search

- find min & max weight of packages
- traveral min to max weight 
  -- traverse compelte weights[] c
  -- check if selected weight we shiped then calculate total day need to ship all packages
  
  Once traversal done then check total days equal to to given days then return the selected weight 
   which is minimum as we are traversing from min to max

   TC - 0(N * log(max(weights[]) - min(weights[]) + 1))
   SC - 0(1)
   */
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int[] maxAndTotalWeight = getWeightDetails(weights);
        int low = maxAndTotalWeight[0];
        int high = maxAndTotalWeight[1];
        int minCapacity = -1;

        while(low <= high){    
          int mid = (high + low) / 2;
          int totalDays = calculateTotalDaysToShip( weights, mid );
         
          if(  totalDays <= days ){
            minCapacity = mid ;
            high = mid - 1;
          }else{
            low = mid + 1;
          }

        }

        return minCapacity;
    }
    
    int calculateTotalDaysToShip(int[] weights, int dayCapacity){
       int totalDays = 1;
       int existingLoad = 0;

       for(int index = 0; index < weights.length; index++){
         
         if( existingLoad + weights[index] <= dayCapacity){ 
            existingLoad += weights[index];
         }
         else {
            totalDays++; //next day
            existingLoad = weights[index]; // next day weight
          }
          
       }
       return totalDays;
    }

    int[] getWeightDetails(int[] weights){
        int max = Integer.MIN_VALUE;
        int totalWeigth = 0;

        for(int index = 0; index < weights.length; index++){
            max = Math.max(max, weights[index]);
            totalWeigth += weights[index];
        }

        return new int[] {max,totalWeigth};
    }

}