/* Approach - 1 Brute Force 
-- Traverse number 1 to max number of array element
  --- if current element is less or equla then K
      then 
         shift k by one place
      else
         k is missing number

TC - 0(N)
SC - 0(1)
*/
class Solution {
    public int findKthPositive(int[] arr, int k) {
      for(int index = 0; index < arr.length; index++){
       if( arr[index ] <= k) 
           k++;
       else
         break;
      }
      return k;
    }

    
}