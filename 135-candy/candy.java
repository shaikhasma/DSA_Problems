/*
  Approach - prefix & suffix array
  TC - 0(N) + 0(N) + 0(N)
        lefft right.  calculation
     - 0(3N)
  SC - 0(N) + 0(N)
       left.  right
    - 0(2N)
*/
class Solution {
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
}