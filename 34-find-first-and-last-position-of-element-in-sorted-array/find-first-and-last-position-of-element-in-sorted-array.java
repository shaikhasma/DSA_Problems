class Solution {
    public int[] searchRange(int[] arr, int target) {
        int firstIndex = -1;
        int lastIndex = -1;

        firstIndex = lowerBound(arr, target);
        
        if(firstIndex != -1){
            lastIndex = upperBound(arr, target);
            lastIndex = lastIndex == -1 ? arr.length - 1: lastIndex - 1;
        }
        return new int[]{firstIndex, lastIndex};
    }
    
    int lowerBound(int[] arr, int target){
       int low = 0; 
       int high = arr.length - 1;
       int lower = -1;

       while(low <= high){
        int mid = (low + high) / 2;

        if(target == arr[mid])  
            lower = mid;
        
        if(target <= arr[mid])
            high = mid - 1;
        else
            low = mid + 1;
       }

       return lower;
    }   

     int upperBound(int[] arr, int  target){
        int low = 0;
        int high = arr.length - 1;
        int upper = -1;

        while(low <= high){
            int mid = (low + high) / 2;

            if(target < arr[mid]){
                upper = mid;
                high = mid - 1;
            }
            else
               low = mid + 1;
        }

        return upper;
     }
}