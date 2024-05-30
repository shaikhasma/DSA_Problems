/* Approach - 1 Recursion
  0 1 2 3
 [1 2 3 1]

    f(3) ( max ( 3,4))
        pick = 1 + f(1) // 2 = 3
            pick = 2 + f(-1)// 0
                -1 -- > 0
        notPick = f(2) ==> 4 
            pick = 3 + f(0)//1 == 4
                1 -- > 1
            notPick = f(1); // 2
                pick = 2 + f(-1)//0
                    -1 --> 0
            max(4, 2)
        
TC - 0(2^N)
SC - 0(N) stack space

public int rob(int[] nums) {
        return solve(nums, nums.length - 1);
    }

    int solve(int[] arr, int index){
     if(index == 0)
        return arr[index];
     
     if( index < 0) 
        return 0;

     int pick = arr[index] + solve(arr, index - 2 );
     int notPick = solve(arr, index - 1);

     return Math.max(pick, notPick);
    }

Approach - 2 Recursion + Memoiation
    use dp array and store ans first time 
TC - 0(N)
SC - 0(N) + 0(N) 
     dp[].   stack
   - O(N) 

*/
class Solution {
    public int rob(int[] nums) {
        Integer[] dp = new Integer[nums.length];
        
        return solve(nums, nums.length - 1, dp);
    }

    int solve(int[] arr, int index, Integer[] dp){
     if(index == 0)
        return arr[index];
     
     if( index < 0) 
        return 0;

     if(dp[index] != null)
        return dp[index];

     int pick = arr[index] + solve(arr, index - 2 , dp);
     int notPick = solve(arr, index - 1, dp);

     return dp[index] = Math.max(pick, notPick);
    }
}