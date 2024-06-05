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
    int solv(int[] arr, int index, int prevIndex){
        
        if(index < 0 )
          return 0;
        
        //take
        int pick = 0;
        if(prevIndex == -1 || arr[index] < arr[prevIndex] )
            pick = 1 + solv(arr, index - 1, index );
        
        // not pick
        int notPick = solv(arr, index - 1, prevIndex);

        return Math.max(pick, notPick);
    }

Approch - 3 Recursion + Memoiation
TC - 0(N)
SC - 0(N * N) + 0(N) dp[] & stack

Program - 
     public int lengthOfLIS(int[] arr) {
      int[][] dp = new int[arr.length][arr.length + 1];
      for(int[] row : dp)
        Arrays.fill(row, -1);

      return solv(arr, arr.length - 1, -1, dp);
    }

    int solv(int[] arr, int index, int prevIndex, int[][] dp){
        
        if(index < 0 )
          return 0;
        
        if(dp[index][prevIndex + 1] != -1)
            return dp[index][prevIndex + 1];

        //take
        int pick = 0;
        if(prevIndex == -1 || arr[index] < arr[prevIndex] )
            pick = 1 + solv(arr, index - 1, index , dp);
        
        // not pick
        int notPick = solv(arr, index - 1, prevIndex, dp);

        return dp[index][prevIndex + 1] = Math.max(pick, notPick);
    }

Approch - 4 Tabulation
TC - 0(NM)
SC - 0(NM)

Program - Tabulation n - 1 to 0
        public int lengthOfLIS(int[] arr) {
            int len=arr.length;
            int dp[][]=new int[len+1][len+1];
            
            
            for(int i=len-1;i>=0;i--){
                for(int prev=i-1;prev>=-1;prev--){
                
                int take=0;
                if(prev == -1 || arr[i] > arr[prev])
                    take = 1 + dp[i + 1][i + 1];
                
                int notTake = dp[i + 1][prev + 1];

                dp[i][prev + 1] = Math.max(take, notTake);
            }
            }

            return dp[0][0];
    }

*/

class Solution {
    
    public int lengthOfLIS(int[] arr) {
        int len=arr.length;
        int dp[][]=new int[len+1][len+1];
        
        
        for(int i=len-1;i>=0;i--){
            for(int prev=i-1;prev>=-1;prev--){
            
            int take=0;
            if(prev == -1 || arr[i] > arr[prev])
                 take = 1 + dp[i + 1][i + 1];
              
            int notTake = dp[i + 1][prev + 1];

            dp[i][prev + 1] = Math.max(take, notTake);
         }
        }

        return dp[0][0];
    }
}
