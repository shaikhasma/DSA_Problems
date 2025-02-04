/* using kadane's algo
Tc - 0(N)
SC - 0(1)
*/
class Solution {
    public int maxAscendingSum(int[] nums) {
        int maxSum = nums[0];
        int sum = nums[0];

        for(int index = 1; index < nums.length; index++){
           
            if(nums[index - 1] < nums[index]){
                sum += nums[index];    
            }
            else{
                sum = nums[index];
            } 
            
                maxSum = Math.max(maxSum, sum); 
        }

        return maxSum;
    }
}