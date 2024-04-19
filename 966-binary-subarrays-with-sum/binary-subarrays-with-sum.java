/* Approach -  Sliding Window 
 1. find all subarray with sum <= to goal & count it
 2. find all subarray with sum <= goal - 1 to goal & count it
       <=goal   <= goal - 1

1. left & right start with 0
2. take sum of nums[right] into sum
3. if somewhere sum > goal then 
   shrink window 
   -- sum = sum - nums[left]
   -- left++
4. count subarray 
   count = count + (right - left. + 1)

TC - 0( N + N) + 0( N + N)
   - 0(4N)
   - 0(N)

SC - 0(1)

 1.*/
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
       return countSubArrayWithSum(nums, goal) - countSubArrayWithSum(nums, goal - 1) ;
    }

    int countSubArrayWithSum(int[] nums, int goal){
        if(goal < 0 )
           return 0;

        int left = 0; 
        int right = 0;
        int count = 0;
        int sum = 0;
         
        while( right < nums.length){
          sum += nums[right];

          while(sum > goal){
            sum -= nums[left];
            left++;
          }

        
        count = count + ( right - left + 1); 
        right++;
        }

        return count;
    }
}