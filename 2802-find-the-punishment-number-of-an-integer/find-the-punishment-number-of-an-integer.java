/*
Approach - preset all numbers whose square sum's digit sum is equal to number
TC - 0(1)
SC - 0(1)

class Solution {
    int arr[] = { 1, 9, 10, 36, 45, 55, 82, 91, 99, 100, 235, 297, 369, 370, 379, 414, 
                  657, 675, 703,  756, 792, 909,918, 945, 964, 990, 991, 999, 1000 };
    
    public int punishmentNumber(int n) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= n) {
                res += arr[i] * arr[i];
            } else {
                break;
            }
        }
        return res;
    }
}
-------------------------------------------------------------------------------------------------
Approach - 2 Recurrsion

1. Iterate Through Numbers (1 to n)

2. For each number curr, compute its square square = curr * curr.
Check if the Square Can Be Partitioned

3. A helper function canPartition(num, target) recursively verifies whether num (the square of curr) can be partitioned such that its segments sum to target (which is curr).
The function considers different segmentations:
Taking the last digit (num % 10)
Taking the last two digits (num % 100)
Taking the last three digits (num % 1000), etc.
Update the Punishment Number

4. If canPartition() returns true, add square to the punishmentNum.
Return the Final Sum

5. The sum of all valid squares is returned as the punishment number.
  
  public int punishmentNumber(int n) {
        int punishmentNum = 0;
        for(int number = 1; number <= n ; number++){
            int square = number * number;
            
            if(canPartition(square, number))
              punishmentNum += square;
        }

        return punishmentNum;

    }
    public boolean canPartition(int num, int target){
        if(num < target || target < 0)
          return false;
        
        //if we found partition sum equal to target 
        if(num == target)
          return true;
               
        boolean lastOneDigit = canPartition(num/10,target-(num%10));
        boolean lastTwoDigit = canPartition(num/100,target-(num%100)); 
        boolean lastThreeDigit = canPartition(num/1000,target-(num%1000));

        return lastOneDigit || lastTwoDigit || lastThreeDigit;
    }

 TC - 0(N * log(s))
 SC - 0(log(s))
 --------------------------------------------------------------------------------------------
 Appraoch - 3 
 
1. Iterate over numbers i from 1 to n

2. Compute i².
   Check if we can partition i² into segments summing to i.

3. Backtracking to check valid partitions
   Maintain a running sum while iterating through the digits.
   If at the end, the sum equals i, return true.
   If any partition leads to a valid sum, stop recursion early.

4. Sum up valid i² values
   If a number satisfies the partitioning condition, add i² to the sum.

   TC - 0( N log N) checking each i takes 0(log i)
   SC - 0( log n) recursion stack 
        0(1)
*/

class Solution {
    public int punishmentNumber(int n) {
        int sum = 0;
        for (int index = 1; index <= n; index++) {
            int square = index * index;
            if (canPartition(String.valueOf(square), 0, index)) {
                sum += square;
            }
        }
        return sum;
    }

    private boolean canPartition(String num, int index, int target) {
        if (index == num.length()) 
            return target == 0;

        int sum = 0;
        for (int i = index; i < num.length(); i++) {
            sum = sum * 10 + (num.charAt(i) - '0');

           // if (sum > target) 
           //     break;

            if (canPartition(num, i + 1, target - sum))
               return true;
        }
        return false;
    }
}