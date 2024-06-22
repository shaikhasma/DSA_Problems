class Solution {
    public int rob(int[] arr) {
        int n = arr.length;
        int prev = arr[0];
        int prevOfPrev = 0;

        for( int index = 1; index < n; index++){

            int take = arr[index];
            if(index > 1)
                take += prevOfPrev;
            
            int notTake = prev;
            int current = Math.max(take, notTake);
            prevOfPrev = prev;
            prev = current;
        }

        return prev;
    }
    
}