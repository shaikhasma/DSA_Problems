/* 
Approach 1 Recursion Brute force generate all increasing subsets and count length
TC - 0(2^n)
SC - 0(N)

int max; 
    public int lengthOfLIS(int[] arr) {
      List<List<Integer>> list = new ArrayList<>();
      max = 0;

      solv(arr, new ArrayList<Integer>(), list, 0);
      return max;
    }

    void solv(int[] arr, ArrayList<Integer> temp , 
                    List<List<Integer> > list, int index){
        
        if(index == arr.length ){
          max = Math.max(max, temp.size());
          list.add(new ArrayList<>(temp));
          return; 
        }
        
        //take
        if(temp.size() != 0 ){
            if( arr[index] > temp.get(temp.size() - 1)){
                temp.add(arr[index]);
                solv(arr, temp, list,  index +1);
                temp.remove(temp.size() - 1);
            }
               
        }else{
             temp.add(arr[index]);
             solv(arr, temp, list,  index +1);
             temp.remove(temp.size() - 1);
        }
        
        solv(arr, temp, list, index + 1);
    }

Approach 2 Recursion 
TC - 0(2^n)
SC - 0(N)

Program - 
    public int lengthOfLIS(int[] arr) {
        return solv(arr , 0, -1);
    }

    int solv(int[] arr, int index, int prevIndex){
        if(index >= arr.length)
            return 0;
        
        int pick = 0;
        if(prevIndex == -1 || arr[index] > arr[prevIndex]){
            pick = 1 + solv(arr, index + 1, index);
        }

        int notPick = solv(arr, index + 1, prevIndex);

        return Math.max(pick, notPick);

    }

Approch - 3 Recursion + Memoiation
TC - 0(N)
SC - 0(N * N) + 0(N) dp[] & stack

Program -
    public int lengthOfLIS(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        return solv(arr , 0, -1,dp);
    }

    int solv(int[] arr, int index, int prevIndex, int[][] dp){
        if(index >= arr.length)
            return 0;
        
        if(dp[index][prevIndex + 1] != -1)
            return dp[index][prevIndex + 1];

        int pick = 0;
        if(prevIndex == -1 || arr[index] > arr[prevIndex]){
            pick = 1 + solv(arr, index + 1, index, dp);
        }

        int notPick = solv(arr, index + 1, prevIndex, dp);

        return dp[index][prevIndex + 1] = Math.max(pick, notPick);
    }

Approch - 4 Tabulation
TC - 0(NM)
SC - 0(NM)

Program - Tabulation 
      int[][] dp = new int[arr.length + 1][arr.length + 1];
        
        for(int index = arr.length - 1; index >= 0; index--){
            for(int prevIndex = index - 1; prevIndex >= -1; prevIndex--){
                
                int pick = 0;
                if(prevIndex == -1 || arr[index] > arr[prevIndex]){
                    pick = 1 + dp[index + 1][index + 1];
                }

                int notPick = dp[index + 1][prevIndex + 1];
                
                dp[index][prevIndex + 1] = Math.max(pick, notPick);
            }
        }
        
        return dp[0][0];  
Approach - Space Optimization
TC - 0(N*N)
SC - 0(N) + 0(N)

Program -
    public int lengthOfLIS(int[] arr) {
            int n = arr.length;
            int[] nextRow = new int[n+1];

            for(int index = n - 1; index >= 0; index--){
                int[] currentRow = new int[n + 1];

                for(int prevIndex = index - 1; prevIndex >= -1 ; prevIndex--){
                    
                    int take = 0;
                    if(prevIndex == -1 || arr[index] > arr[prevIndex])
                        take = 1 + nextRow[index + 1];

                    int notTake = nextRow[prevIndex + 1];

                    currentRow[prevIndex + 1] = Math.max(take, notTake);
                }
                
                nextRow = currentRow;
            }

            return nextRow[-1 + 1];
    }
Approach - 6 Tabulation Algorithm to find the longest increasing subsequence
0,1,0,3,2,3
1 1 1 1 1 1 dp
1 2 2 3 3 4
here max dp[] value is 4 
ans = 4 [0 0 1 2 3]
TC - 0(N*N)
SC = 0(N) dp

Program - 
    public int lengthOfLIS(int[] arr) {
            
            int[] dp = new int[arr.length];
            Arrays.fill(dp, 1);

            for( int index = 0; index < arr.length; index++){
                for(int prevIndex = 0; prevIndex <= index - 1; prevIndex++){
                    
                    if(arr[prevIndex] < arr[index])
                        dp[index] = Math.max(dp[index] , 1 + dp[prevIndex]);

                }
            }

            int ans = -1;

            for(int index = 0; index < arr.length; index++){
                ans = Math.max(ans, dp[index]);
            }

            return ans;
    }
Print LIS using dp[] & hash[] pick backtrack index in hash[]

/*
   print lis using dp & hash []
   
   TC - 0(n*n) + 0(logN)
   SC - 0(N) + 0(N)
Program - 
        class Solution {
            public ArrayList<Integer> longestIncreasingSubsequence(int n, int arr[]) {
                int[] dp = new int[n];
                int[] hash = new int[n];
                for( int index = 0; index < n; index++){
                    dp[index] = 1;
                    hash[index] = index;
                }
                
                for(int index = 0; index < n; index++){
                    for(int prevIndex = 0; prevIndex <= index - 1; prevIndex++ ){
                        if(arr[prevIndex] < arr[index] && dp[index] < 1 + dp[prevIndex]){
                            dp[index] =  1 + dp[prevIndex];
                            hash[index] = prevIndex;  
                        }
                        
                    }
                }
                
                int ans = -1;
                int lastIndex = -1;
                
                for( int index = 0; index < n; index++){
                    if(dp[index] > ans){
                        ans = dp[index];
                        lastIndex = index;
                    }
                }
                
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(arr[lastIndex]);
                
                //traverse till reach the initialize value i.e same index
                while(hash[lastIndex] != lastIndex) {
                    lastIndex = hash[lastIndex];
                    temp.add(arr[lastIndex]);
                }
                
            Collections.reverse(temp);
            return temp;
            }
        }

*/

class Solution {
    
    public int lengthOfLIS(int[] arr) {
        
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);

        for( int index = 0; index < arr.length; index++){
            for(int prevIndex = 0; prevIndex <= index - 1; prevIndex++){
                
                if(arr[prevIndex] < arr[index])
                    dp[index] = Math.max(dp[index] , 1 + dp[prevIndex]);

            }
        }

        int ans = -1;

        for(int index = 0; index < arr.length; index++){
            ans = Math.max(ans, dp[index]);
        }

        return ans;
    }
}
