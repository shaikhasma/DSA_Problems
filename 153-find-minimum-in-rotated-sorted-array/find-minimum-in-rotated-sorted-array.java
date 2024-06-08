/*
[4,5,6,7,0,1,2]
 0 1 2 3 4 5 6
         l.  g 
 min +
 which part sorted
 before moving to other part take min from sorted part
*/
class Solution {
    public int findMin(int[] arr) {
        int min = Integer.MAX_VALUE;

        int low = 0;
        int high = arr.length - 1;

        while(low <= high){
            int mid = high - ( high - low) / 2;
            
            if(arr[low] <= arr[mid]){
                min = Math.min(min, arr[low]);
                low = mid + 1;
            }else{
                min = Math.min(min, arr[mid]);
                high = mid - 1;
            }
        }
        return min;
    }
}