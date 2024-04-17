/*
[5,7,7,8,8,10]
 0 1 2 3 4 5
       
*/

class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] ans = new int[2];
        ans[0] = firstPosition(A, target);
        ans[1] = lastPosition(A, target);
        return ans;

        
    }

    int firstPosition(int[] A, int target){
        int low = 0;
        int high = A.length - 1;
       
        
        int firstPosition = -1;
        while(low <= high){
            int mid = high - ( high - low) / 2;
            
            if(A[mid] == target){
                firstPosition = mid;
                high = mid - 1;
            }
            else if( A[mid] < target){
               low = mid + 1;
               
            }
            else{
                high = mid - 1;
            }
        }

        return firstPosition;
    }

    int lastPosition(int[] A, int target){
        int low = 0;
        int high = A.length - 1;
       
        
        int lastPosition = -1;
        while(low <= high){
            int mid = high - ( high - low) / 2;
            
            if(A[mid] == target){
                lastPosition = mid;
                low = mid + 1;
            }
            else if( A[mid] < target){
               low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return lastPosition;
    }

}