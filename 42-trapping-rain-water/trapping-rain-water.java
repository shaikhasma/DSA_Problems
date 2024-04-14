/*
  Approach - 1Brute Force
  TC - 0(n2)
  SC - 0(1)
*/
class Solution {
    public int trap(int[] arr) {
      int waterTrapped = 0;

      for(int index = 0 ; index < arr.length; index++){
         
         waterTrapped += Math.min(prevGreater(arr, index ), nextGreater(arr, index) ) - arr[index];

      }                                                            
      return waterTrapped;
    }

    int prevGreater(int[] arr, int start){
        int prev = Integer.MIN_VALUE;
        int k = start;
        
        while( k >= 0){
            prev = Math.max(prev, arr[k]);
            k--;
         }

        return prev;
        
    }

    int nextGreater(int[] arr, int start){
        int next= Integer.MIN_VALUE;
        int k = start;
        
        while(k < arr.length){
            next = Math.max(next, arr[k]);
            k++;
         }

        return next;
        
    }
}