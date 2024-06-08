class Solution {
    public int[] searchRange(int[] arr, int target) {
        // 5,7,7,8,8,10 target 8 
        

        int firstIndex = lowerBound(arr, target);
        int lastIndex = -1;

        if(firstIndex != -1) {
          lastIndex = upperBound(arr, target) ;
          lastIndex = lastIndex == -1 ? arr.length - 1: lastIndex - 1; 
        } 

        return new int[] {firstIndex , lastIndex};
    }
    
    int lowerBound(int[] arr, int target){
        int low = 0;
        int high = arr.length - 1;
         int lowerBound = -1;

        while(low <= high){
            int mid = high - (high - low) / 2 ;

            if(target == arr[mid])
                lowerBound = mid;

            if(target <= arr[mid]){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return lowerBound;
    }   

     int upperBound(int[] arr, int  target){
        int low = 0;
        int high = arr.length - 1;
        int upperBound = -1;
        
        while( low <= high){
            int mid = high - (high - low) / 2;

            if(target < arr[mid]){
                upperBound = mid;
                high = mid - 1;
            }
            else
               low = mid + 1;
        }

        return upperBound;
     }


}