/*
  Approach - 2 Using prefix
  4,2,0,3,2,5
  0 4 4 4 4 4
  5 5 5 5 5 0
  
 
  prefix == N
  postfix = N
  traversing to calculate trapped water for all building = N 
  == 3N
  TC - 0(3N) 
     =0(N)
  SC - 0(N + N) 
    = 0(N)
*/
class Solution {
    public int trap(int[] arr) {
      int waterTrapped = 0;
      int[] prefix = prevGreater(arr);
      int[] postfix = nextGreater(arr);

      for(int index = 0 ; index < arr.length; index++){
         waterTrapped += Math.min( prefix[index], postfix[index]) - arr[index];
      }                                        

      return waterTrapped;
    }

    int[] prevGreater(int[] arr){
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];

        for(int index = 1 ; index < arr.length; index++){
            prefix[index] = Math.max(arr[index] , prefix[index - 1]);
        }

        return prefix;
    }

    int[] nextGreater(int[] arr){
        int[] postfix = new int[arr.length];
        postfix[arr.length - 1] = arr[arr.length - 1];
    
        for(int index = arr.length - 2; index >= 0; index--){
            postfix[index] = Math.max(arr[index] , postfix[index + 1]);
        }

        return postfix;
    }
}