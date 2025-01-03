/* Approach - 1 Carry Forward + prefix approach
1. left side sum store in a variable
2. all righside sum keep in prefix array
3. traverse input array check left part sum >= right part 
   if yes calulate
5 add current element into left sum then go for next index

TC = 0 (N)
SC = 0 (N)

here actually sum can go beyond max limit hence we take longp[] array and long leftSum variable

Note - calculating sum of all element with each index actually not required check second approach


*/

class Solution {
    public int waysToSplitArray(int[] nums) {
        long[] rightPrefix = rightPrefixSum(nums);
        long leftSum = nums[0];
        int validWays = 0;

        for(int index = 1; index < nums.length; index++){
            if(leftSum >= rightPrefix[index])
                validWays++;

            leftSum += nums[index];
        }

        return validWays;

    }
    
    long[] rightPrefixSum(int[] nums){
        int n = nums.length;
        long[] rightPrefix = new long[n];

        rightPrefix[n - 1] = nums[n - 1];
        for(int index  = n - 2; index >= 0; index--){
            rightPrefix[index] = rightPrefix[index + 1] + nums[index];
        }

        return rightPrefix;
    }

}