/* Approach - 1 Binary Search
 [1,10,3,10,2], m = 3, k = 2

After day 1: [x, _, _, _, _]   //  we cant make as we dont have 2 adjecent
After day 2: [x, _, _, _, x]   // we cant make as we dont have 2 adjecent
After day 3: [x, _, x, _, x]   // we cant make as we dont have 2 adjecent
so return -1
Take low = minBloomDay
take high = maxBloomDay

   --> traverse N flowers if less then or equal to day
       if yes then count bouquets 

   -->if count is greater or equal to given m return true as its is possible

   --> if possible for mid day keep mid value it may or may not minimum days to make bouquets
        as it is possible and we need min value then 
           go to left and skip right
      else not possible 
           go to right and skip left
      
TC - 0( log (max(bloomDay) - min(blomDay[] + 1) * N)
SC - 0(1)
*/
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int[] minMaxDay = getMinMaxBoolmDay(bloomDay);
        int low = minMaxDay[0];
        int high = minMaxDay[1];
        int minDays = -1;

            while(low <= high){
                int mid = (high + low) / 2;
            
                if( isBouquetsPossible (bloomDay, mid, m, k)){
                minDays = mid;
                high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }

          return minDays;
        }

    boolean isBouquetsPossible(int[] bloomDay, int mid, int m, int k){
        int adjFlowerCount = 0;
        int totalBouquets = 0;
            
            for(int flowerIndex = 0; flowerIndex < bloomDay.length; flowerIndex++){
                
                        if( bloomDay[flowerIndex] <= mid)
                          adjFlowerCount++;
                        else {
                            totalBouquets += (adjFlowerCount / k );
                            adjFlowerCount = 0;
                        }
                        
            }

            totalBouquets += (adjFlowerCount / k );
            return totalBouquets >= m;
    }

    int[] getMinMaxBoolmDay(int[] bloomDay){
        int maxDay = Integer.MIN_VALUE;
        int minDay = Integer.MAX_VALUE;

        for(int index = 0; index < bloomDay.length; index++){
          maxDay = Math.max(maxDay, bloomDay[index]);
          minDay = Math.min(minDay, bloomDay[index]);
        }

        return new int[]{ minDay, maxDay};
    }
}