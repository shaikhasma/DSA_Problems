/*
0  1 2 3 4 5 6
[4,5,6,7,0,1,2]. target 9

[3,4,0,1,2] 

== mid

left sorted
  = lie
right sorted
  = lie

-1 

mid
*/
class Solution {
    public int search(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int index = -1;
        while(low <= high){
            int mid = high - (high - low) / 2;

            if(arr[mid]== target)
                return mid;
            
            if(arr[low] <= arr[mid]){
                if(target >= arr[low] && target <= arr[mid]){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }else{
                if(target >= arr[mid] && target <= arr[high]){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }

        }
        return index;
    }
}