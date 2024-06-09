// 1417  15 
// 1,2,3,1,1].  3 - 8 4
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // max - sum
        int low = getMax(weights);
        int high = getSum(weights);

        int minCapacity = 0;

        while(low <= high){
            int mid = high - (high - low) / 2;
            int totDays = calDays(weights, mid);

            if (totDays <= days ){
                 minCapacity = mid;
                 high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return minCapacity;
        
    }

    int calDays (int[] arr, int minCapacity){
       int day = 1;
       int currentWt = 0;

       for(int index = 0; index < arr.length; index++){
          if(currentWt + arr[index] <= minCapacity){
             currentWt += arr[index];
          }else{
            day++;
            currentWt = arr[index];
          }
       }

       return day;
    }

    int getMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int index = 0; index < arr.length; index++){
            max = Math.max(max, arr[index]);
        }

        return max ;
    }


    int getSum(int[] arr){
        int sum = 0;
        for(int index = 0; index < arr.length; index++){
            sum += arr[index];
        }

        return sum ;
    }
}