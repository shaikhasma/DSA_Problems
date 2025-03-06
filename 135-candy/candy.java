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

*/
class Solution {
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
}