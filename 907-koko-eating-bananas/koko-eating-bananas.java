/* approach - 2 Binary Search
1. find max element / max number of banana
2. apply binary search on 1 to max values this is nothing but k
3. check per hr k banana we eat piles[mid]

TC - 0(n * log( max(piles[]) ) )

SC - 0(1)

3  6 7 11. h = 8  k = ? per hour how many min banana koko should eat
        3  6 7 11.
1 == 

  
*/
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        

     int maxBanana = maxBanana(piles);
     int low = 1;
     int high = maxBanana;
     int minK = Integer.MAX_VALUE;

        while(low <= high){
            int totalHr = 0;
            int mid = (high + low )/ 2;

            totalHr = calculateTotalHr(piles,mid);

            if(totalHr <= h) 
                minK = Math.min(minK, mid);
            
            if( totalHr <= h) 
                high = mid - 1;
            else 
               low = mid + 1;
        }

    return minK;

    }

     int calculateTotalHr(int[] piles, int k){
        int totalHr = 0;
        for( int index = 0; index < piles.length ; index++){
            totalHr += Math.ceil((double)piles[index] /(double) k);
        }
        return totalHr;

     }
    int maxBanana(int[] piles){
        int maxVal = Integer.MIN_VALUE;
        for(int index = 0; index < piles.length; index++){
            maxVal = Math.max(maxVal, piles[index]);
        }

        return maxVal;
    }
}