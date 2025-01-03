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

Approach - 2 Total sum + carryForward
1. calculate tot sum
2. traverse array carry forward left sum variable 

   right pary sum = totalSum - carry forward value 
   compare carry forward sum >= right part value

TC - 0(N) + 0(N) = 0(N)
SC - 0(1)

*/

class Solution {
    public int waysToSplitArray(int[] nums) {
      
        long totalSum = 0;
        long leftSumCarry = 0;
        int validWays = 0;

        for(int index = 0; index < nums.length; index++){
            totalSum += nums[index];
        }

        for(int index = 0; index < nums.length - 1; index++){
            leftSumCarry += nums[index];
            long righPartSum = totalSum - leftSumCarry;

            if(leftSumCarry >= righPartSum)
                validWays++;
        }

        return validWays;
    }
}