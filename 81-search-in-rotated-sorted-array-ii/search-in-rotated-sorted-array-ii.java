/*
 [2,5,6,0,0,1,2]. 3
  0 1 2 3 4 5  6

 [2,2 2,2 3,0,1,2] 1
  0 1 3 4 5 6 7  8
  
  low = mid = high. not apply
  low ++ 
  high --

*/

class Solution {
    public boolean search(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        
        if(arr.length == 1 && target != arr[0])
            return false;
            
        while(low <= high){
            int mid = high - (high - low) / 2;
            // [1,0,1,1,1]
            //  0 1 2 3 4
             //     l.m  h
            if(arr[mid] == target)
                return true;

            if(arr[low] == arr[mid] && arr[mid] == arr[high]){
                //shrink 
                low++;
                high--;
                continue;
            }

            if(arr[mid] >= arr[low]){
                if(target >= arr[low] && target <= arr[mid]){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }

            }else{
                if(target >= arr[mid] && target <= arr[high]){
                    low = mid + 1;
                }else{
                   high = mid - 1;
                }
            }
        }

        return false;

    }
}