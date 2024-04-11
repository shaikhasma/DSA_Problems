/* Approach - 2 Binary Search
-- Sort array
-- apply binary search on 1 to max position of array
-- for every distance i.e mid check can we place all balls with that min distance
      --- if yes take that distance and check for more distance 
      -- if not possible return the previous possible max distance for which we could able to place all balls with mid distance

TC - 0(N * log(max() - min()))
SC - 0(1)

*/
class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        
        int low = 1;
        int high = position[position.length - 1];
        int maxDistance = -1;
        while(low <= high){
            int mid = high - (high - low) / 2;

            if(canPlaceAllBalls(position, mid, m) ){
                maxDistance = mid;
                low = mid +1;
            }
            else
                high = mid - 1;
                    
        }

        return maxDistance;
    }

    boolean canPlaceAllBalls(int[] position, int minDistance, int m){
        int countBalls = 1;
        int lastBall = position[0];

        for(int index = 1; index < position.length; index ++){
            
            if(position[index] -  lastBall >= minDistance){
                countBalls++;
                lastBall = position[index];
            }

            if(countBalls >= m)
               return true;
        }

        return false;
    }
}