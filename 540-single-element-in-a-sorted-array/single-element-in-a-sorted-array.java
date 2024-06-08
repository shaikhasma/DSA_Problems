/*
   3,   3,7,7,11,11,         11
   0 1 2 3 4 5 6 7 8
*/

class Solution {
    public int singleNonDuplicate(int[] arr) {
        int low = 1;
        int high = arr.length - 2;
        int ans = -1;
        if(arr.length == 1)
           return arr[0];
        //left AIOB
        if(arr[0] != arr[1])
            return arr[0];
        //RIGH AIOB

        if(arr[arr.length - 2] != arr[arr.length - 1])
            return arr[arr.length - 1];

        while(low <= high){
            int mid = high - (high - low) / 2;

            if(arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]){
               return arr[mid];
            }

            if( mid % 2 == 0 && arr[mid] != arr[mid + 1] ||
                mid % 2 == 1 && arr[mid] != arr[mid - 1]){

                 high = mid - 1;
            }else{
                
                low = mid + 1;
            }
        }

        return -1;
    }
}