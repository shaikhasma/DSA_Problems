/*
[1,2,3,4,5,6,7,8]
 1 2 3 5 8
 2 3 5 8
 3 4 7
 4 5
 6 7 
 8
apporach 1. Recursion
 TC - 0(2^N *  N)
 SC - 0(N) stack 

 public int lenLongestFibSubseq(int[] arr) {
        if(arr.length <= 2){
            return arr.length;
        } 

        int maxLen = 0; // 0(N^2)
        for(int start = 0; start < arr.length; start++){
            for(int end = start + 1; end < arr.length; end++){
                maxLen = Math.max(maxLen , solve(arr, start, end, end + 1, 2));
            }
        }

        return maxLen > 2 ? maxLen : 0;
    }
     // 0 (N)
     int solve(int[] arr, int prev1, int prev2, int current, int count) {
        if (current >= arr.length) {
            return count;
        }

        int taken = count;
        if (arr[current] == arr[prev1] + arr[prev2]) {
            taken = solve(arr, prev2, current, current + 1, count + 1);
        }

        int notTaken = solve(arr, prev1, prev2, current + 1, count);

        return Math.max(taken, notTaken);
    }
--------------------------------------------------------------------------------------------------------------------------------
Approach - 2 Recursion + Hashing to find next element
1. pull all element and its index into hashmap
2. start prev 1 from 0 to N - 1
           prev2 from prev1 + 1 to N- 1
             capture max of recusion call
3. In Recursion call,
    - check arr[prev1] + arr[prev2] sum is exit in map 
    - if yes then directly jump to that index and count it
    - if now what every count we have return it as we can extend this fibonacci subseq further

TC - 0(N^2 log N) log for solve()
SC - 0(N) + 0(N)

  Map<Integer,Integer> indexMap = new HashMap<>();
    public int lenLongestFibSubseq(int[] arr) {
        if(arr.length <= 2){
            return arr.length;
        } 
        // populate hashmap with index
        for( int index = 0; index < arr.length; index++)
            indexMap.put(arr[index], index);

        
        int maxLen = 0;
        for(int prev2 = 0; prev2 < arr.length; prev2++){
            for(int prev1 = prev2+ 1; prev1 < arr.length; prev1++){
                maxLen = Math.max(maxLen , solve(arr, prev2, prev1, 2));
            }
        }

        return maxLen > 2 ? maxLen : 0;
    }
     //log N
     int solve(int[] arr, int prev2, int prev1, int count) {
        int next = arr[prev2] + arr[prev1];
        
        if (indexMap.containsKey(next)) { 
            int nextIndex = indexMap.get(next); 
            return solve(arr, prev1, nextIndex, count + 1);
        }

        return count;//if no next valid element;
    }
 ---------------------------------------------------------------------------------

 Approach - 3 Memoriazation + HashMap Lookup
 1. Need dp[prev1][perv2] to track fibo seriers ending at  prev1 & prev2 
 2. dp[n][n]
 Here we dont need extra count param for solve as we can track if from dp[][]

 TC - 0(N^2)
 SC - O(N^2)+O(N)+O(N)
    - O(N^ 2)
*/
class Solution {
    Map<Integer,Integer> indexMap;
    int[][] dp;

    public int lenLongestFibSubseq(int[] arr) {
        if(arr.length <= 2){
            return arr.length;
        } 
        // populate hashmap with index 0 (N)
        indexMap = new HashMap<>();
        for( int index = 0; index < arr.length; index++)
            indexMap.put(arr[index], index);

        //dp array
        dp = new int[arr.length][arr.length];

        int maxLen = 0; // N^2
        for(int prev2 = 0; prev2 < arr.length; prev2++){
            for(int prev1 = prev2+ 1; prev1 < arr.length; prev1++){
                maxLen = Math.max(maxLen , solve(arr, prev2, prev1));
            }
        }

        return maxLen > 2 ? maxLen : 0;
    }
     //log N
     int solve(int[] arr, int prev2, int prev1) {
        if(dp[prev2][prev1] != 0)
            return dp[prev2][prev1];

        int next = arr[prev2] + arr[prev1];
        int maxLen = 2;

        if (indexMap.containsKey(next)) { //extend maxLen only if possible
            int nextIndex = indexMap.get(next); 
            maxLen =  1 + solve(arr, prev1, nextIndex);
        }

        return dp[prev2][prev1] = maxLen;//if no next valid element track it in dp[][];
    }
}
