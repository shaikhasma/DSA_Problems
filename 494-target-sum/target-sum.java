class Solution {
    public int findTargetSumWays(int[] arr, int target) {
      
        return countWays(arr, 0, 0, target);
    }

    int countWays(int[] arr, int index, int sum, int target) {
       if(index == arr.length){
        
        if(sum == target){
            return 1;
        }
        return 0;
       }

       int plus = countWays(arr, index + 1, sum + arr[index], target);
       int minus = countWays(arr, index + 1, sum - arr[index], target);
       
       return plus + minus;
    }
}