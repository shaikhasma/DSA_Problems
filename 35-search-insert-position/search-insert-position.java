/* Approach - 2 Binary Search 
- start low = 0 & high < n - 1
- calculating  mid & search if found return index
- else if number less then mid check with previous element 
   if lies then return mid
  else check with next element if leis then return mid + 1

  do the same thing till low <= high
0 1 2 3
1,3,5,6.  target = 2
l h     

TC - 0(N)
SC - 0(N)
*/
class Solution {
    public int searchInsert(int[] nums, int target) {
       
        int low = 0; 
        int high = nums.length - 1;
        int insertIndex = nums.length;

        while( low <= high ){
            int mid = high - (high - low) /2;
            
            if(nums[mid] == target) return mid;

            if(nums[mid] > target){
               insertIndex = mid ;
               high = mid - 1;
            }else{
               low = mid + 1;
            }
        }
       return insertIndex;
    }
}