/*
  Approach - prefix & suffix array
  TC - 0(N) + 0(N) + 0(N)
        lefft right.  calculation
     - 0(3N)
  SC - 0(N) + 0(N)
       left.  right
    - 0(2N)

    public int candy(int[] ratings) {
        int[] left = leftNeighbor(ratings);
        int[] right = rightNeighbor(ratings);
        int minSum = 0;

        for(int index = 0; index < ratings.length; index++){
            minSum += Math.max(left[index], right[index]);
        }

        return minSum;
    }

    int[] leftNeighbor(int[] arr){
      int[] left = new int[arr.length];
      left[0] = 1;

      for(int index = 1; index < arr.length; index++){
          if(arr[index - 1] < arr[index])
            left[index] = left[index - 1] + 1;
          else
            left[index] = 1;
      }

      return left;
    }

    int[] rightNeighbor(int[] arr){
      int[] right = new int[arr.length];
      right[arr.length - 1] = 1;

      for(int index = arr.length - 2; index >= 0; index--){
          if(arr[index] > arr[index + 1])
            right[index] = right[index + 1] + 1;
          else
            right[index] = 1;
      }

      return right;
    }
--------------------------------------------------------------------------------------------------------------------------
Approach - 2 carry forward + right prefix
TC - 0(2N)
SC - 0(N)

1. calcuate right distribution 
2. carry left value and min candy distribution 
3. every time carry left value 
    max(left, right[index])
    add into sum
4. return sum
public int candy(int[] ratings) {
        int left = 1;
        int[] right = rightNeighbor(ratings);
        int minSum = Math.max(left, right[0]);

        for(int index = 1; index < ratings.length; index++){
            if(ratings[index - 1] < ratings[index])
                left = left + 1;
            else
                left = 1;

            minSum += Math.max(left, right[index]);
        
        }

        return minSum;
    }
    
    int[] rightNeighbor(int[] arr){
      int[] right = new int[arr.length];
      right[arr.length - 1] = 1;

      for(int index = arr.length - 2; index >= 0; index--){
          if(arr[index] > arr[index + 1])
            right[index] = right[index + 1] + 1;
          else
            right[index] = 1;
      }

      return right;
    }
Approach - 3 Slop Approach 
if no equal values then capture sum and move ahead with out pick and down
if increasing incremnt pick and capture into count
if decreasing capture count then move increment count( as we dont need distributiong we need only sum so down can be incremnted)

Note if pick is less and slop is greater means we need highest pick 
     slow > pick then need to add gap between them as we already added pick value 

     
TC -  0(N)
SC -  0(1)

*/
class Solution {
    public int candy(int[] arr) {
        int index = 1;
        int n = arr.length;
        int totCandy = 1;

        while(index < n){
            // check for equal ratings
            if(arr[index - 1] == arr[index]){
                totCandy = totCandy + 1;
                index++;
                continue;
            }
            
         
            /* ---------check for higher ratings(left to Right) ------------------
             Each child with a higher rating than the previous as previous child has less candy count.
             So, first increment top++ 
                    then add top into totCandy
             */
            int pick = 1;
            while(index < n && arr[index - 1] < arr[index]){
               pick++;
               totCandy += pick;
               index++;
            }

            
            /*-------check for lower ratings( Right to left ) -----------------------
             Each child with a lower rating must get fewer candies than the previous child as previous child had more candies.
             So, first add down into totCandy
                    then increment down++
            */
            int slop = 1;
            while(index < n && arr[index - 1] > arr[index]){ 
                totCandy += slop;
                slop++;
                index++;
            }

            if(slop > pick)
                totCandy = totCandy + (slop - pick);
        }

        return totCandy;
        
    }
}