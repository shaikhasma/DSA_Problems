/*
        1,3,5,4,7
dp      1 2 2 1 1
count.  1 1 1 1 1
*/
class Solution {
    public int findNumberOfLIS(int[] arr) {
        int[] dp = new int[arr.length];
        int[] count = new int[arr.length];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int maxLen = -1;

        for( int index = 0; index < arr.length; index++){
            for(int prevIndex = 0; prevIndex <= index - 1; prevIndex++){
                
                if(arr[prevIndex] < arr[index]){
                    if(dp[index] < 1 + dp[prevIndex]){
                        dp[index] = 1 + dp[prevIndex];
                        count[index] = count[prevIndex];
                    }
                    else if(dp[index] == dp[prevIndex] + 1){
                        count[index] = count[index] + count[prevIndex] ;
                    }
                    
                }
                
            }
            maxLen = Math.max(maxLen, dp[index]);
        }

        int totLis = 0;
        for( int index = 0; index < dp.length; index++){
            if(maxLen == dp[index]) 
                totLis += count[index];
        }

        return totLis;
    
    }
}