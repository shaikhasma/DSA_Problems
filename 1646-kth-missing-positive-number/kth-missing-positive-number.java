class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;

        while(low <= high){
            int mid = (low + high)/2;
            int missNo = arr[mid] - (mid + 1);

            if(missNo < k)
                low = mid + 1;
            else
                high = mid - 1;
            
        }

        return high + 1 + k;//low + k
    }
}